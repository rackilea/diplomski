try (PrintWriter writer = new PrintWriter("C:\\Users\\hp\\Desktop\\result3.txt", "UTF-8"))
    String line;
    while ( (line = r.readLine()) != null) {
        System.out.println(line);
        writer.write(line);
    }
}