Scanner userInput = new Scanner(System.in);
    while(true){
        System.out.print("Enter input: ");
        String foo = userInput.nextLine();

        if (foo.length () == 0) {
            break;
        }

        //do stuff with foo
        System.out.format("[%s]\n",foo);
    }