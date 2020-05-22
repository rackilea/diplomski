for (int i = 0; i < myArray.length; i++) {
        String b = Integer.toBinaryString(myArray[i]);

        if (b.length() < 8) {
            b = "000000000".substring(0, 8 - b.length()).concat(b);
        } else {
            b = b.substring(b.length() - 8);
        }

        System.out.print(b + " ");
 }