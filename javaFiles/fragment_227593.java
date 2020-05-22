public class ChapterComparator {
    // just a simple test
    public static void main(String[] args) {
        List<String> ids = Arrays.asList("10.2", "3.1.1", "10", "1.1", "2", "1");
        Collections.sort(ids, ChapterComparator::compare);
        ids.forEach(System.out::println);
    }

    public static int compare(String o1, String o2) {
        String[] split1 = o1.split("\\."), split2 = o2.split("\\.");
        int result = 0;
        for (int i = 0; i < Math.min(split1.length, split2.length); i++) {
            // compare current segment
            if ((result = Integer.compare(Integer.parseInt(split1[i]), Integer.parseInt(split2[i]))) != 0) {
                return result;
            }
        }
        // all was equal up to now, like "1.1" vs "1.1.1"
        return Integer.compare(split1.length, split2.length);
    };
}