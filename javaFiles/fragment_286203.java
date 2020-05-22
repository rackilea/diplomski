do {
        System.out.println("\nName : " + characterName + " " + characterClass);
        System.out.println("Level : " + Level); // Output the value of Level

        int []statValues = new int[]{Str, Dex, Con, Int, Wis, Cha};
        String[] stats = new String[] { "Str", "Dex", "Con", "Int", "Wis", "Cha" };

        int amount;
        for (int i = 0; i < statValues.length; i++) {
            statValues[i] = rollDice();
            amount = statValues[i];

            System.out.print(stats[i] + " : " + statValues[i]);

            if (amount == 10 || amount == 11) {
                Bonus[i] = 0;
                System.out.print(" [ " + Bonus[i] + "]\n");
            }
            // Bonus value for integers less than 10
            else if (amount < 10) {
                Bonus[i] = 0;
                bonusCounter = amount;
                while (bonusCounter < 10) {
                    if (bonusCounter % 2 == 1) {
                        Bonus[i] = Bonus[i] + 1;
                    }
                    bonusCounter = bonusCounter + 1;
                }
                System.out.print("[-" + Bonus[i] + "]\n");
            }
            // Bonus value for integers greater than 10
            else {
                Bonus[i] = 0;
                bonusCounter = 11;
                while (bonusCounter <= amount) {
                    if (bonusCounter % 2 == 0) {
                        Bonus[i] = Bonus[i] + 1;
                    }
                    bonusCounter = bonusCounter + 1;
                }
                System.out.print("[+" + Bonus[i] + "]\n");
            }

        }

        System.out.println("Type \"yes\" to re-roll or press any key to terminate the program");
        reRoll = sc.next();
    } while (reRoll.equals("yes"));
}