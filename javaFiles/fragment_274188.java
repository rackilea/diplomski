public class MergeSet {

    public static void main(String... args) {
        List<Set<String>> list = new ArrayList<>();
        String[] A = {"a", "c", "e", "g"};
        String[] B = {"b", "d", "f", "h"};
        String[] C = {"c", "e", "f"};
        String[] D = {"b"};

        list.add(new HashSet<>(Arrays.asList(A)));
        list.add(new HashSet<>(Arrays.asList(C)));
        list.add(new HashSet<>(Arrays.asList(B)));
        list.add(new HashSet<>(Arrays.asList(D)));

        List<Set<String>> newGroups = merge(list);
        System.out.println(newGroups);

    }

    @SuppressWarnings("empty-statement")
    private static <T> List<Set<T>> merge(List<Set<T>> list) {
        if (list == null || list.isEmpty()) {
            return list;
        }
        List<Set<T>> merged = new ArrayList<>();
        do {
            merged.add(list.get(0));
            list.remove(0);

            while (mergeStep(merged.get(merged.size() - 1), list));
        } while (!list.isEmpty());
        return merged;
    }

    private static <T> boolean mergeStep(Set<T> setToCheck, List<Set<T>> remainingList) {
        boolean atLeastOnceMerged = false;
        Iterator<Set<T>> iterator = remainingList.iterator();
        while (iterator.hasNext()) {
            Set<T> elements = iterator.next();
            boolean doMerge = !Collections.disjoint(elements, setToCheck);
            if (doMerge) {
                atLeastOnceMerged |= doMerge;
                setToCheck.addAll(elements);
                iterator.remove();
            }
        }
        return atLeastOnceMerged;
    }