public class SortOnlyNumbers {
    public static void main(String[] args) {
        sortOnlyNumbers(new String[] { "d", "1", "4", "c", "9", "6" });
        sortOnlyNumbers(new String[] { "109", "87", "911", "b", "645" });
        sortOnlyNumbers(new String[] { "77", "19", "#", ".", "95" });
        sortOnlyNumbers(new String[] { "8", "99", "14", "2", "5", "6", "49" });
    }

    private static void sortOnlyNumbers(String[] array) {
        List<Integer> indexes = new ArrayList<Integer>();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            try {
                numbers.add(Integer.parseInt(array[i]));
                indexes.add(i);
            } catch (NumberFormatException e) {
                // don't care
            }
        }
        Collections.sort(numbers, Collections.reverseOrder());
        for (int i = 0; i < numbers.size(); i++) {
            array[indexes.get(i)] = String.valueOf(numbers.get(i));
        }
        System.out.println(Arrays.toString(array));
    }
}