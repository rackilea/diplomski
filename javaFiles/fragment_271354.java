import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {

    public static void main(String[] args) {
        final List<Integer> list = Arrays.asList(1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3);
        System.out.println("Input: " + list);
        System.out.println("Solution1 (regroup): " + regroup(list, 3));
        System.out.println("Solution2 (regroup2): " + regroup2(list, 5));
        System.out.println("Solution3 (groupSize constructor): " + new GroupedList<Integer>(list, 5));
        System.out.println("Solution3 (typeCount constructor): " + new GroupedList<Integer>(3, list));
        System.out.println("Demonstration of Solution3 emptyList constructor for groupSize 5");
        final GroupedList<Integer> groupedList = new GroupedList<Integer>(5);
        final List<List<Integer>> oneOfEachType = groupedList.getOneOfEachType();
        System.out.println("Ungrouped: " + groupedList);
        System.out.println("Grouped:" + oneOfEachType);
        // While addAll is shorter code, add also works
        groupedList.addAll(Arrays.asList(11, 12, 13, 14, 15));
        groupedList.addAll(Arrays.asList(21, 22, 23, 24, 25));
        groupedList.add(31);
        groupedList.add(32);
        groupedList.add(33);
        groupedList.add(34);
        groupedList.add(35);
        System.out.println("After adding 3 groups");
        System.out.println("Ungrouped: " + groupedList);
        System.out.println("Grouped:" + oneOfEachType);
        groupedList.addAll(Arrays.asList(41, 42, 43, 44, 45));
        System.out.println("After adding 4th group");
        System.out.println("Ungrouped: " + groupedList);
        System.out.println("Grouped:" + oneOfEachType);
    }

    /**
     * Solution one: returns the reordered list, if you know how many different types are to be handled
     *
     * @param list
     *         input list with equally-sized groups of the same type following each other
     * @param typeCount
     *         count of equally sized groups are in {@code list}
     * @param <T>
     *         type of elements in {@code list}
     * @return new {@link java.util.ArrayList} consisting of the same elements as in {@code list} in the desired order.
     */
    private static <T> List<T> regroup(final List<T> list, final int typeCount) {
        final int groupSize = list.size() / typeCount;
        final ArrayList<T> result = new ArrayList<T>(list.size());
        for (int i = 0; i < groupSize; i++) {
            for (int j = 0; j < typeCount; j++) {
                result.add(list.get(i + j * groupSize));
            }
        }
        return result;
    }


    /**
     * Solution two: returns the reordered list, if you know how many items of each type are added
     *
     * @param list
     *         input list with equally-sized groups of the same type following each other
     * @param groupSize
     *         size of one of the equally sized groups in {@code list}
     * @param <T>
     *         type of elements in {@code list}
     * @return new {@link java.util.ArrayList} consisting of the same elements as in {@code list} in the desired order.
     */
    private static <T> List<T> regroup2(final List<T> list, final int groupSize) {
        final ArrayList<T> result = new ArrayList<T>(list.size());
        for (int i = 0; i < groupSize; i++) {
            for (int j = 0; i + j * groupSize < list.size(); j++) {
                result.add(list.get(i + j * groupSize));
            }
        }
        return result;
    }

    /**
     * Solution three: wrapper class around the original list. This solution reflects changes to the original list
     * immediately and can be used to change the original list if desired
     *
     * @param <T>
     *         type of elements in this list
     */
    public static class GroupedList<T> extends AbstractList<T> {

        private final List<T> list;
        private final int     groupSize;

        /**
         * Empty list, than can be filled with groups of {@code groupSize} elements one group after another.
         */
        public GroupedList(final int groupSize) {
            this.list = new ArrayList<T>();
            this.groupSize = groupSize;
        }

        /**
         * Backed by a list with same-typed groups consisting each of {@code groupSize} elements
         */
        public GroupedList(final List<T> list, final int groupSize) {
            this.list = list;
            this.groupSize = groupSize;
        }


        /**
         * Backed by a list with {@code typeCount} same-typed groups consisting each of the same number of elements
         */
        public GroupedList(final int typeCount, final List<T> list) {
            this.list = list;
            this.groupSize = list.size() / typeCount;
        }

        /**
         * Number of items of the same type. You need to add this many elements at once.
         */
        public int getGroupSize() {
            return groupSize;
        }

        /**
         * Number of different types in each sub-sequence.
         */
        public int getTypeCount() {
            return list.size() / groupSize;
        }

        @Override
        public boolean add(T t) {
            return list.add(t);
        }

        @Override
        public T get(int index) {
            final int realIndex = getRealIndex(index);
            return list.get(realIndex);
        }

        @Override
        public T set(int index, T element) {
            final int realIndex = getRealIndex(index);
            if (realIndex < list.size()) {
                return list.set(realIndex, element);
            } else {
                throw new IndexOutOfBoundsException("Adding to this List-implementation is not possible");
            }
        }

        /**
         * Translate reordered index to index of underlying list
         */
        private int getRealIndex(int index) {
            final int typeCount = getTypeCount();
            if (typeCount * groupSize != list.size()) {
                throw new IllegalStateException("There is an incomplete group. Can't establish list order.");
            }
            final int offsetInGroup = index / typeCount;
            final int groupStart = (index % typeCount) * groupSize;
            return offsetInGroup + groupStart;
        }

        @Override
        public int size() {
            return list.size();
        }

        /**
         * Produce a list of the lists generated by {@link #getOneOfEachType(int)}. The generated list is read-only
         * while the contained lists are writable. Size of this list will always be the same as {@link #getGroupSize()}.
         */
        public List<List<T>> getOneOfEachType() {
            return new AbstractList<List<T>>() {
                @Override
                public List<T> get(int index) {
                    return getOneOfEachType(index);
                }

                @Override
                public int size() {
                    return groupSize;
                }
            };
        }

        /**
         * Get the {@code groupNumber}-th list consisting of on element of each type. You can replace elements of this
         * list and as elements are added to {@link tc.vom.test.with.deps.Sorting.GroupedList} elements will also be
         * visible through the returned list.
         */
        public List<T> getOneOfEachType(final int groupNumber) {
            return new AbstractList<T>() {

                @Override
                public T get(int index) {
                    return list.get(getRealIndex(index));
                }

                @Override
                public T set(int index, T element) {
                    return list.set(getRealIndex(index), element);
                }

                private int getRealIndex(int index) {
                    final int typeCount = getTypeCount();
                    if (index >= typeCount) {
                        throw new IndexOutOfBoundsException();
                    }
                    if (typeCount * groupSize != list.size()) {
                        throw new IllegalStateException("There is an incomplete group. Can't establish list order.");
                    }
                    return index * groupSize + groupNumber;
                }

                @Override
                public int size() {
                    return getTypeCount();
                }
            };
        }
    }
}