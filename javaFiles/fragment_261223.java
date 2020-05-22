public class Class {
    public static void main(String[] args) {
        boolean[] oldShape = new boolean[]{
                false, true, false,
                true, true, false,
                false, false, false
        };

        // THIS DOENS TWORK
        boolean[] newShape = oldShape;

        //THIS WILL WORK
//        boolean[] newShape = new boolean[9];

        output(oldShape);

        newShape[2] = oldShape[0];
        newShape[5] = oldShape[1];
        newShape[8] = oldShape[2];
        newShape[1] = oldShape[3];
        newShape[4] = oldShape[4];
        newShape[7] = oldShape[5];
        newShape[0] = oldShape[6];
        newShape[3] = oldShape[7];
        newShape[6] = oldShape[8];

        output(newShape);
    }

    private static void output(boolean[] s) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                System.out.print(s[i*3+j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}