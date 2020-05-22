try (PrintWriter pw = new PrintWriter(csvFile)) {
    pw.printf("%s\n", FILE_HEADER);

    for(int i = 0; i < finalResult.size(); i+=2) { // no need to modulo
        pw.printf("%s\n", finalResult.get(i)); // no idea what type finalResult.get(i) is, format it if you need to
    }
}