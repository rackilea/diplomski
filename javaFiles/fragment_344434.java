public class LinkedListSplitByFive {

        private static List<List<String>> splitByGroupAsList(List<String> list, int elementsInGroup) {
            List<List<String>> result = new ArrayList<List<String>>();

            List<String> group = new ArrayList<String>(elementsInGroup);
            for (String s : list) {
                group.add(s);
                if (group.size() == elementsInGroup) {
                    result.add(group);
                    group = new ArrayList<String>(elementsInGroup);
                }
            }
            if (!group.isEmpty()) {
                result.add(group);
            }
            return result;
        }

        private static List<String> splitByGroupAsString(List<String> list, int elementsInGroup) {
            List<List<String>> lists = splitByGroupAsList(list, elementsInGroup);
            List<String> result = new ArrayList<String>(lists.size());

            for (List<String> group : lists) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < group.size(); i++) {
                    sb.append(group.get(i));
                    if (i == group.size() - 1) {
                        sb.append(";");
                    } else {
                        sb.append(", ");
                    }
                }
                result.add(sb.toString());
            }
            return result;
        }

        public static void main(String[] args) {

            List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11");

            System.out.println(splitByGroupAsList(list, 5));
            // [[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11]]

            System.out.println(splitByGroupAsString(list, 5));
            // [1, 2, 3, 4, 5;, 6, 7, 8, 9, 10;, 11;]
        }
    }