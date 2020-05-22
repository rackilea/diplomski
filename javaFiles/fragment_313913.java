BufferedReader br = new BufferedReader(new FileReader("users.txt"));
        String line = null;
        StringBuilder sb = new StringBuilder();
        String zlepek = "";

        while ((line = br.readLine()) != null) {
            zlepek = // logic to get value
            sb.append(zlepek).append("\n");
        }
        br.close();

        PrintWriter pw = new PrintWriter(new FileWriter("users.txt")); // pass true to append
        pw.print(sb);
        pw.close();