System.out.println("Enter the name of the person (enter 'no' to end): ");
    input_name = kb.nextLine();
    if(!input_name.equalsIgnoreCase("no"))
    {
        name.add(input_name);
        System.out.println("Enter the phone number of that person (enter '-1' to end): ");
        input_number = kb.nextLong();
        kb.nextLine();  // **** added to handle the EOL ****
        phone_number.add(input_number);