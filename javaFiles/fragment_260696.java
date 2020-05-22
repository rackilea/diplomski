FileReader fr = new FileReader("//your//path//to//lines.txt");
        BufferedReader br = new BufferedReader(fr);
        try (PrintWriter writer = new PrintWriter("//your//other//path//newlines.txt", "UTF-8")) {
            String line;
            int num = 1;
            while ((line = br.readLine()) != null) {
                writer.println(num + ". " + line);
                num++;
            }
        }