BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
// while the stream is open and there is something to read
// probably a better condition than `process.isAlive()`
while ((line = br.readLine()) != null) {
    switch (line) {
        case "What is your name?":
            bw.write("John Doe");
            bw.newLine();
            bw.flush();
            break;
        case "What is your contact number?":
            bw.write("123456789");
            bw.newLine();
            bw.flush();
            break;
    }
}