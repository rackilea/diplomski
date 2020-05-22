Scanner sc2 = null;
    try {
        sc2 = new Scanner(new File("translate.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();  
    }
    while (sc2.hasNextLine()) {
            Scanner s2 = new Scanner(sc2.nextLine());
        while (s2.hasNext()) {
            String s = s2.next();
            System.out.println(s);
        }
    }