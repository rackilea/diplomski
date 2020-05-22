do {
        input = keyboard.nextLine();
        int inputInt = Integer.parseInt(input);
        instructions.add(inputInt);
        termIns = input.substring(0);

    } while(!termIns.equals("1"));