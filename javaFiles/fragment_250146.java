String line, customerName, currentVal, newVal;
try (Scanner sc = new Scanner(new File("salesrep.txt"))) {
    while (sc.hasNextLine()) {
        line = sc.nextLine().replace("\"", "");
        //skip blank lines (if any)
        if (line.equals("")) {
            continue;
        }
        String[] lineData = line.split(",");
        customerName = lineData[0];
        currentVal = lineData[1]; // or:  double currentVal = Double.parseDouble(lineData[1]);
        newVal = lineData[2];     // or:  double newVal = Double.parseDouble(lineData[2]);
        System.out.println("" + customerName + " " + currentVal + " " + newVal);
    }
}
catch (FileNotFoundException ex) {
    ex.printStackTrace();
}