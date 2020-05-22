int[][] ints = new int[4][4]; // Let's say you have a 4 * 4 ints array filled like this

        ints[0][0] = 1;
        ints[0][1] = 2;
        ints[0][2] = 3;
        ints[0][3] = 4;

        ints[1][0] = 5;
        ints[1][1] = 6;
        ints[1][2] = 7;
        ints[1][3] = 8;

        ints[2][0] = 9;
        ints[2][1] = 10;
        ints[2][2] = 11;
        ints[2][3] = 12;

        ints[3][0] = 13;
        ints[3][1] = 14;
        ints[3][2] = 15;
        ints[3][3] = 16;

        StringBuilder sb = new StringBuilder(); // String Builder to create the table structure before writing it to the file.

        for (int[] int1 : ints) {
            for (int j = 0; j < int1.length; j++) {
                sb.append(int1[j]).append("\t"); // Add tab to delimite the elements
            }
            sb.append("\r\n"); // Add new line character
        }

        System.out.println(sb);

        Path path = Paths.get("C:\\Users\\youruser\\Documents\\test.txt"); // The path to your file

        Files.write(path, sb.toString().getBytes()); // Writes to that path the bytes in the string from the stringBuilder object.