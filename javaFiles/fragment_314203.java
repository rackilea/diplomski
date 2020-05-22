boolean active = true;

        while (active) {
            System.out.println("Write action (buy, fill, take):");
            String action = scanner.nextLine();

            switch(action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    int choiceOfCoffee = Integer.valueOf(scanner.nextLine());
                    if (choiceOfCoffee == 1) {
                        waterInMachine -= waterNeededEspresso;
                        coffeeInMachine -= coffeeNeededEspresso;
                        diposableCupsInMachine -= 1;
                        moneyInMachine += costOfEspresso;
                        break;
                    } else if (choiceOfCoffee == 2) {
                        waterInMachine -= waterNeededLatte;
                        milkInMachine -= milkNeededLatte;
                        coffeeInMachine -= coffeeNeededLatte;
                        diposableCupsInMachine -= 1;
                        moneyInMachine += costOfLatte;
                        break;
                    } else if (choiceOfCoffee == 3) {
                        waterInMachine -= waterNeededCappucino;
                        milkInMachine -= milkNeededCappucino;
                        coffeeInMachine -= coffeeNeededCappucino;
                        diposableCupsInMachine -= 1;
                        moneyInMachine += costOfCappucino;
                        break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int answer1 = Integer.valueOf(scanner.nextLine());
                    waterInMachine += answer1;
                    System.out.println("Write how many ml of milk do you want to add:");
                    int answer2 = Integer.valueOf(scanner.nextLine());
                    milkInMachine += answer2;
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int answer3 = Integer.valueOf(scanner.nextLine());
                    coffeeInMachine += answer3;
                    System.out.println("Write how many disposable cups of coffee do you want to add:");
                    int answer4 = Integer.valueOf(scanner.nextLine());
                    diposableCupsInMachine += answer4;
                    break;
                case "take":
                    System.out.println("I gave you $" + moneyInMachine);
                    moneyInMachine = 0;
                    break;
                case "exit":
                    active = false;
                    break;
            }
        }