Scanner kb = new Scanner (System.in);
        System.out.println("Fiddlesticks! Give me a 5 letter word: ");
        String l1 = kb.nextLine();
        l1 =l1.toUpperCase();
        char let1 = l1.charAt(0);
        char let2 = l1.charAt(1);
        char let3 = l1.charAt(2);
        char let4 = l1.charAt(3);
        char let5 = l1.charAt(4);
        System.out.println(let1);
        System.out.println(let2);
        System.out.println(let3);
        System.out.println(let4);
        System.out.println(let5);

        kb.close();