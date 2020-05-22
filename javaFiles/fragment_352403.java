outer:
do {
      Scanner reader = new Scanner(System.in);
      String input = reader.nextLine().trim();
      for (Element sy : Element.values()) {
         if (sy.symbol.equalsIgnoreCase(input)) {
                System.out.println("Element: " + sy + " (" + sy.symbol + ")" + "\nGroup: " + sy.group + "\nAtomic Mass: " + sy.weight);
                reader.close();
                break outer;
          } else {
              try {
                    cName = Element.valueOf(input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase());
                    System.out.println("Element: " + cName + " (" + cName.symbol + ")" + "\nGroup: " + cName.group + "\nAtomic Mass: " + cName.weight);
                    reader.close();
                    break outer;
              } catch(IllegalArgumentException e) {
                    System.out.println("That name or symbol is not valid. Please try again. ");
                    continue;
              }
          }
     }
} while (true);