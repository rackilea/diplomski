public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    boolean found = false;
    do {
        System.out.println("Enter the symbol of an element in the periodic table. ");
        String input = reader.nextLine().trim();

        for (Element e : Element.values()) {
            if (e.symbol.equals(input)) {
                found = true;
                System.out.println("Element: " + e + " (" + e.symbol + ")" + "\nGroup: " + e.group + "\nAtomic Mass: " + e.weight);
            }
        }
        if (!found)
            System.out.println("That symbol is not valid. Please try again. ");
    } while (!found);
    reader.close();
}