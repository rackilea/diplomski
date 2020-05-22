List<String>coord = new ArrayList<String>();

    while(sc.hasNextLine())
    {
        String pair = sc.nextLine();
        String[] s = pair.split("\t");
        coord.add(s[0]);
        coord.add(s[1]);
    }

    System.out.println(coord);