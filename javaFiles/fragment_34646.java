boolean foundPumbaa = false;
while (s.hasNext()) {
    if (s.next().equalsIgnoreCase("pumbaa")) {
        foundPumbaa = true;
        System.out.println("We found Pumbaa"); // do something
        break;
    }
}
if (!foundPumbaa) {
    System.out.println("We didn't find Pumbaa");
}