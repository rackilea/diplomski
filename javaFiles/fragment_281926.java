public static void main(String[] args)
{
    Set<Integer>s1 = createWinningNumber();
    Set<Integer>s2 = getUserNumber();

    System.out.println("Your ticket was: "+s2);
    System.out.println("Winning numbers: "+s1);

    s1.retainAll(s2); // s1 contains the intersection of previous s1 and s2
    System.out.println("You had " + s1.size() +
      " numbers in common with the winning number.");
}