// append the last score to the end of the file
    try {
        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
        output.newLine();
        output.append("" + points);
        output.close();

    } catch (IOException ex1) {
        System.out.printf("ERROR writing score to file: %s\n", ex1);
    }
}