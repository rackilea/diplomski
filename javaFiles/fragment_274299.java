String s;
    BufferedReader in = new BufferedReader(new FileReader("file.txt"));
    while ((s = in.readLine()) != null) {
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                System.out.println(c);
            }
        }
    }