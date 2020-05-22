String s = " x1 2 3 -1 x2 2 x3 4 x4 5 -1 lastone 4";

    Scanner sc = new Scanner(s);

    String currentName = null;
    int currentNumber = -1;

    while (sc.hasNext()) {

        String token = sc.next();

        if (token.matches("-?\\d+")) {
            currentNumber = Integer.parseInt(token);
        } else {
            if (currentName != null && currentNumber > -1) {
                System.out.println(currentName + " = " + currentNumber);
            }
            currentName = token;
            currentNumber = -1;
        }
    }

    if (currentName != null && currentNumber > -1) {
        System.out.println(currentName + " = " + currentNumber);
    }