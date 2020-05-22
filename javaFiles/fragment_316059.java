String strVal = scan.nextLine();
try {
val = Integer.parseInt(strVal);
} catch (NumberFormatException e) {
    //maybe try again, or break the code ... or proceed as you wish.
}