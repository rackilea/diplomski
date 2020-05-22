String s = "xxxooooooxxx";
        String[] sp = s.split("");
        boolean xFlag = false;

        for (int i = 0; i < sp.length; i++) {
            if (sp[i].equals("x") && !xFlag) {
                System.out.print("x");
            } else if (sp[i].equals("o")) {
                xFlag = true;
            } else if (sp[i].equals("x") && xFlag) {
                System.out.print("X");
            }
        }