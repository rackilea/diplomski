PrintWriter writer = new PrintWriter("C:\\Users\\hp\\Desktop\\result3.txt", "UTF-8");
while (true) {
        line = r.readLine();
        if (line == null) {
            break;
        }
        System.out.println(line);
        writer.write(line);
}
writer.close();