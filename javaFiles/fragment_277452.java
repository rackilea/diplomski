StringBuilder binary = new StringBuilder();
    StringBuilder hexa = new StringBuilder();

    Scanner scanner = new Scanner(System.in);

    System.out.println("Eingabe Zahl: ");
    String zahl = scanner.nextLine();

    String[] ipArray = zahl.split("\\.");

    for (int i = 0; i < ipArray.length; i++) {
        int temp = Integer.parseInt(ipArray[i]);
        if (temp > 0 && temp <= 255) {

            hexa.append(Integer.toHexString(temp));
            hexa.append('.');
            binary.append(Integer.toBinaryString(temp));
            binary.append('.');
        }
    }
    hexa.deleteCharAt(hexa.length() - 1);
    binary.deleteCharAt(binary.length() - 1);

    System.out.println("Hex: " + hexa.toString());
    System.out.println("Bin: " + binary.toString());