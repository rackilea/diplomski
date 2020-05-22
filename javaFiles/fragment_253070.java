try (Scanner sc = new Scanner(new File("polinom.txt"))) {
    StringBuilder tmp;
    while (sc.hasNextLine()) {
        String line = sc.nextLine().replace("\\","/");
        System.out.println("EQUATION:\t" + line);

        // Split the Equation line on the +, -, *, and / operators
        String[] equationNumbers = line.split("[\\+\\-\\\\*\\/]");
        String[] operators = new String[equationNumbers.length - 1];
        tmp = new StringBuilder();
        for (int i = 0; i < equationNumbers.length; i++) {
            System.out.println("\tEquation Number " + (i + 1) + " is: " + equationNumbers[i].trim());
            tmp.append(equationNumbers[i]);
            if (i < operators.length) {
                operators[i] = line.substring(tmp.length(), tmp.length() + 1);
                System.out.println("\t\tOperator after Number is: " + operators[i]);
                tmp.append(operators[i]);
            }
        }
        System.out.println();
    }
}
catch (FileNotFoundException ex) {
    Logger.getLogger("Get Operators").log(Level.SEVERE, null, ex);
}