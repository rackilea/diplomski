private void printString(ArrayList<String> operations, ArrayList<String> set) {
        int numerOfStrings = 0;
        int numberOfletters = 0;
        String toPrint = operations.get(1);
        for (String s : set) {
            if (s.contains(toPrint)) {
                String[] arr = s.split(" ");
                numerOfStrings = arr.length;
                numberOfletters = s.length() - (numerOfStrings - 1);
                break;
            }

        }
        System.out.println(numerOfStrings + " " + numberOfletters);
    }