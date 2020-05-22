Scanner input = new Scanner(System.in);
    System.out.print("please enter the string of characters: ");
    String str = input.nextLine();
    char[] store = new char[str.length()];
    int count = 0;
    boolean charInStore = false;
    for (int i = 0; i < str.length(); i++) {
        charInStore = false;
        for (int j = 0; j < store.length; j++) {
            if (str.charAt(i) == store[j]) {
                charInStore = true;
                break;
            }
        }
        if (!charInStore) {
            store[count] = str.charAt(i);
            count++;
        }
    }
    System.out.println(str);
    System.out.println(new String(store).trim());