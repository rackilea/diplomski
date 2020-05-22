public void draw()
{
    for (int i = 0; i < 4; i++)
    {
        int x = ObArray[i].getXCoor();
        int y = ObArray[i].getYCoor();

        System.out.println("x" + x);
        System.out.println("y" + y);

        // Manipulate items in the array
        // ObArray[i].setXCoor(10);
    }
}