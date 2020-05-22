try (BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))) {
    while (st.hasMoreTokens()) {
        bw.write(st.nextToken());
        bw.newLine();
    }
}