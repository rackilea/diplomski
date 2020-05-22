Scanner scan = new Scanner(new File("C:\\input.txt"));
if (scan.hasNext()) {
    // skip header line
    scan.nextLine();
}

// write contents to output file
FileWriter fw = new FileWriter("C:\\output.txt");

// read the rest of the file
while (scan.hasNext()) {
    fw.write(scan.nextLine() + System.getProperty("line.separator"));
}

scan.close();
fw.close();