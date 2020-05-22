public static class InputReader {
        ArrayList<Integer> list = new ArrayList<>(0);
        int arrayLength;
        String readInput;
        Scanner ir = new Scanner(System.in);
        int[] array;
        void readInput() {

            for (int m=0; ;m++) {
                readInput = ir.nextLine();
                if ("q".equals(readInput)) {
                    //problem: arrayLength does not have the value of m outside the loop
                    arrayLength = m;
                    break;
                }

                int intInput = Integer.parseInt(readInput);
                list.add(intInput);
            }
            System.out.println("arrayLength: "+arrayLength);
            array = new int[arrayLength];
        }
    }