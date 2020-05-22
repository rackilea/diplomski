public class GapFinder {
    private static int[] myIntArr = {9, 10, 11, 12, 13, 15};

    public static void main(String[] args) {
        int a = 0,b = 0;
        for (int i = 0; i < myIntArr.length; i++) {
            if(((i + 1) < myIntArr.length) && myIntArr[i] != myIntArr[i + 1] - 1) {
                a = myIntArr[i];
                b = myIntArr[i + 1];
                break;
            }
        }
        if(a == 0 && b == 0){
            System.out.println("There were no gaps.");
        } else{
            System.out.println("Gaps: " + a + " | " + b);
        }
    }
}