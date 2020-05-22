int i = 0;
        for (char ch : inputString.toCharArray()) {
            System.out.printf("%2d: 0x%02X o%03o %3d %c%n",
                i++,
                (int)ch & 0xff,
                (int)ch & 0xff,
                (int)ch & 0xff,
                Character.isISOControl(ch) ? '.' : ch
            );
        }