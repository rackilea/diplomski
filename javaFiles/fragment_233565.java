while (!read.equals("Exit")) {
        switch (op) {
        case "a":
            System.out.println("type your name:");
            read = s.nextLine();
            getName(read);
            print();
            read = s.nextLine();
            op = read;
            break;
        case "b":
            System.out.println("by");
            print();
            read = s.nextLine();
            op = read;
            break;
        default: // Add this to finish loop when you type "Exit"
            read = s.nextLine();
        }

    }