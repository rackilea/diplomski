String s = "$23.24 word -123";
    Scanner fi = new Scanner(s);
    //anything other than alphanumberic characters, 
    //comma, dot or negative sign is skipped
    fi.useDelimiter("[^\\p{Alnum},\\.-]"); 
    while (true) {
        if (fi.hasNextInt())
            System.out.println("Int: " + fi.nextInt());
        else if (fi.hasNextDouble())
            System.out.println("Double: " + fi.nextDouble());
        else if (fi.hasNext())
            System.out.println("word: " + fi.next());
        else
            break;
    }