Scanner in1; //field declaration with no assignment
Scanner in2; //field declaration with no assignmetn

    /* Omitted Class declaration & other code */

try {
    in1 = new Scanner(new File("countryPopulation.txt")); //these require FNF to be caught
    in2 = new Scanner(new File("countryArea.txt"));
    while (in1.hasNextLine() && in2.hasNextLine()) {
        IOAndExceptionHandling country1 = new IOAndExceptionHandling(
                in1.nextLine());
        IOAndExceptionHandling country2 = new IOAndExceptionHandling(
                in1.nextLine());
        double density = 0;
        if (country1.getCountry() == country2.getCountry()) {
            density = country2.getValue() / country1.getValue();
            out.println(country1.getCountry() + " : " + density);
        }
    }
} catch (FileNotFoundException f) {
    System.out.println("FileNotFound!");
} catch (IOException e) {
    e.printStackTrace();
} finally {
    in1.close();
    in2.close();
    out.close();
}