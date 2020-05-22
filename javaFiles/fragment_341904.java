Scanner scanner = new Scanner(new File("YourFilePath"));
    String prev = null;
    String current;
    while (scanner.hasNextLine())
    {
        current = scanner.nextLine();
        if (current.contains("YourRegEx"))
            break;
        else
            prev = current;
    }
    String next = scanner.nextLine();