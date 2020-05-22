Scanner read = new Scanner(System.in);
    System.out.println("Input words, enter blank to stop");
    boolean working = true;
    do {
        if (working == false) {
            break;
        }
        String a = read.nextLine();
        if (a.isEmpty()) {
            working = false;
            System.out.println("no data");

        } else {

            Container.addWord(a);
        }

    } while (working == true);