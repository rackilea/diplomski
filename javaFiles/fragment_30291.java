System.out.print("Please enter the file name: \n");

    while (true)
    {
        @SuppressWarnings("resource")
        Scanner keyboard = new Scanner(System.in);

        String filename = keyboard.nextLine();

        if(filename.equals(null)){
            break;
        }



        File file = new File(filename);
        if (!file.exists()){
            System.out.println("File 'double_input3.txt' does not exist ");
            System.out.println("Please enter the file name again:");
            continue;
        }

        break;
    }

    System.out.println("finsihed");