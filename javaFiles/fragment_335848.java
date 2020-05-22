while (fs.hasNextLine()) {
    String s = fs.nextLine();
            //System.out.println(Players[q].toString());
        for (int i = 0; i < Players.length; i++) {
            if (s.equals(Players[i].toString())) {
                Players[i].addGroup(alpha[i / n]);
                System.out.println(Players[i].toString());
                writer.println(Players[i].toString());
            }
        }
            //q++;
    }