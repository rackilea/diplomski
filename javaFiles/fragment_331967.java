public Hospital()
{
    super();
    setSize( /* size */ );
    try
    {
        hospitalImage = ImageIO.read(new File("src\\hospital.jpg"));
    }
    catch (IOException ex)
    {
        //Not handled
    }
}