// Remove bit before the loop which used x and c. It was pointless.
Random myrand = new Random();
for (int mycounter = 0; mycounter < 10; mycounter++)
{
    // Range [33, 127)
    int x = myrand.nextInt(127 - 33) + 33;
    char c = (char) x;
    System.out.print(c);
}