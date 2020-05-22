public class SortTest {
    public static void main(String[] args) {
        String arr[][]={  {"joun","1525565","10"},
                {"ALI","15256562","100"},
                {"FATEH","1525534","20"}   };

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[2]) - Integer.parseInt(o1[2]);
            }
        });

        for (String[] item : arr) {
            System.out.println(Arrays.toString(item));
        }
    }
}