public void play()
{
    int i = 0;
    System.out.println(this.toString());
    while(i < 100 && isChestUnlocked() == false)
    {
        turn();
        System.out.println(this.toString());
        ++i;
    }
    System.out.print("You unlocked the treasure!");
}