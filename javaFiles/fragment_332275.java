if (CurChoice.equals("EUR")) {
        double result = ExcAmount / Euro;
        System.out.println(ExcAmount + " in " + CurChoice + " = £" + result);
    } else if (CurChoice.equals("USD")) {
        double result = ExcAmount / USAD;
        System.out.println(ExcAmount + " in " + CurChoice + " = £" + result);
    } else if (CurChoice.equals("JPY")) {
        double result = ExcAmount / JapYen;
        System.out.println(ExcAmount + " in " + CurChoice + " = £" + result);
    } else if (CurChoice.equals("PLN")) {
        double result = ExcAmount / Zloty;
        System.out.println(ExcAmount + " in " + CurChoice + " = £" + result);
    } else {
        System.out.println("");
    }