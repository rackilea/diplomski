public class StringCheck {
    public static void main(String args[]) {
        String input = "1,2,3,4,5,6,2,3,4,1,4,33,33,33";
        String result = "";
        String[] arr1 = input.split(",");

        System.out.println("Input is : " + input);

        for (int i = 0; i < arr1.length; i++) {
            int k = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i].equals(arr1[j])) {
                    k++;
                    if (k == 2) {
                        if (result.contains(arr1[i])) {
                            break;
                        }
                        result = result + arr1[i] + ",";
                        break;
                    }
                }
            }
        }

        System.out.println("Result is " + result);
    }
}