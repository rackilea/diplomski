for (i = 0; i < 9; i++) {
        if (KollaVinst(spelplan)) {
            break;
        } else {
            CheckMove(spelplan, rad, kolumn);
        }

        if (i % 2 == 0) {
            spelare = 'X';
        } else {
            spelare = 'O';
        }

        System.out.println("Spelare 1 skriv vilken rad: 1-3");
        int x = new Scanner(System.in).nextInt();

        System.out.println("Spelare 1 skriv vilken kolumn: 1-3");
        int y = new Scanner(System.in).nextInt();

        if (CheckMove(spelplan, x, y) == true) {
            MakeMove(spelplan, spelare, x, y);

        }
        System.out.println(" ");
        SkrivUtSpelplan(spelplan);
    }