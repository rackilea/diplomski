String pref = "";

    while(!pref.equalsIgnoreCase("odds") && !pref.equalsIgnoreCase("evens")) {
        pref = input.nextLine();
        if (pref.equals("Odds") || pref.equals("odds")) {
            System.out.println(name + " has picked odds ! Computer will be evens");

        } else if (pref.equals("Evens") || pref.equals("evens")) {
            System.out.println(name + " has picked evens! Computer will be odds");
        } else {
            System.out.println("please enter a valid answer");
        }
    }