public static String combineCSV() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(
                    "d:\\1\\1.csv"));
            BufferedReader r = new BufferedReader(
                    new FileReader("d:\\1\\2.csv"));
            String s1 = null;
            String s2 = null;

            while ((s1 = br.readLine()) != null) {
                list.add(s1);
            }
            while ((s2 = r.readLine()) != null) {
                list.add(s2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String listWord;
        StringBuffer objBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            listWord = list.get(i);

            objBuffer.append(listWord);
            objBuffer.append("\n");

        }
        System.out.println("DONE Enjoy!!");
        System.out.println(objBuffer);
        return objBuffer.toString();
    }