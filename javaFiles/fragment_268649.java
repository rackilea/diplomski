try {

        File file = new File("random1.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String vrstica = bufferedReader.readLine();
        while (vrstica != null) {

            list.add(vrstica);
            vrstica = bufferedReader.readLine();
            // dolzina=list.size();
            // System.out.println(dolzina);

        }

        FileWriter fileWriter = new FileWriter(outputFile);
        PrintWriter out = new PrintWriter(fileWriter);

        for (int idx = 0; idx < list.size(); ++idx) {
            test = list.get(idx);
            dolzina = test.length();

            Random rGenerator = new Random();
            StringBuilder beseda = new StringBuilder(test);

            for (int i = 0; i < dolzina; ++i) {
                int randomInt = rGenerator.nextInt(dolzina);

                beseda.setCharAt(randomInt, '*');
                System.out.println(beseda);

            }
            out.print(beseda);
            out.close();
        }