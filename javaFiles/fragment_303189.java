String option;
    do {
        System.out.println("Type A to add a person to the line (# of requests)\n"
                + "Type N to do nothing and allow the line to be processed\n"
                + "Type Q to quit the application\n");
        option = input.nextLine();

        if(option.equalsIgnoreCase("A")) {
            // do something
        } else if (option.equalsIgnoreCase("N")) {
            // do something
        }

        // notice we don't need an if for 'Q' here. This loop only determines how many
        // times we want to keep going. If it's 'Q', it'll exit the while loop, where
        // we then print the size of the list.

        } while (!option.equalsIgnoreCase("Q"));

    System.out.println("Q was chosen. The number of ppl in this queue are " + line.size());