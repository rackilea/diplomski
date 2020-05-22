try 
{
    Player player = new Player(bufferedtrack);
    player.play(); // add this line
}
catch(JavaLayerException e)
{
    System.out.println("Can't open file!");
}