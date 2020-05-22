while (true) {
    System.out.print("enter: ");
    if (!u.hasNext() || (usrInput = u.next()).equals("exit")) {
        break;
    }
    System.out.println(usrInput);
    System.out.println(findClosestMatch(usrInput.toLowerCase()));
}