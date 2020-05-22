public static void main(String[] args) {
        int[] doublesArray = new int[4];
        doublesArray[0] = 3;
        doublesArray[1] = 3;
        doublesArray[2] = 3;
        doublesArray[3] = 0;

        int[] temp6 = { 3, 3, 3, 0 };
        // length is 4 for both arrays

        if (Arrays.equals(temp6, doublesArray)) {
            System.out.println("Inside if");
        }
    }