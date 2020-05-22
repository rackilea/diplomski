try 
{
    String s = "hi";
    int i = Integer.parseInt(s); // will go into NumberFormatException n
    s = s.substring(-2); // will go into Exception e
}
catch (NumberFormatException n) {
    System.out.println("Please enter a number.");
}
catch (Exception e) {
    System.out.println("Unspecified error (not a NumberFormatException).");
}