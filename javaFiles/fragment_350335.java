String findName = "";
while (!findName.equalsIgnoreCase(SENTINEL)) {
    System.out.print("Please enter name to find phone number or \"" + SENTINEL + "\" to exit: " );
    findName = scanner.nextLine();

    if (phone.containsKey(findName)) {
        System.out.println(findName + "=" + phone.get(findName));
    } else if (!findName.equalsIgnoreCase(SENTINEL)){
        System.out.println("not found");
    }
}