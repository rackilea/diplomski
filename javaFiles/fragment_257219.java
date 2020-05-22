String s = "eh az";
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            if (a >= 97 && a <= 119) {
                System.out.print((char) (s.charAt(i) + 3));
            } else if (a >= 120 && a <= 122) {
                a -= 23;
                System.out.print((char) a);
            } else if (a == 32) {
                System.out.print(" ");
            }
        }