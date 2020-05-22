public class Frequence {

    public static void main(String args[]) {
        int arr[] = { 20, 22, 18, 19, 20, 25, 27, 30, 29, 29, 24, 22, 16, 18, 20, 23, 21, 22, 26, 30, 28, 29, 28, 27,
                26, 26, 27, 23, 24, 25 };
        System.out.println(frekuenc(arr, 22));
    }

    public static int frekuenc(int[] arr, int tempToFind) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer temperature = new Integer(arr[i]);
            if (countMap.get(temperature) != null) {
                countMap.put(temperature, countMap.get(temperature) + 1);
            } else {
                countMap.put(temperature, 1);
            }
        }
        return countMap.get(tempToFind);

    }
}