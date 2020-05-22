public static void main(String[] args) 
    {
        new AsteroidGame();
    }

    public AsteroidGame()
    {      
        //Create SandBox
        SandBox sb = new SandBox();
        sb.init(this);
    }

    public void generate() 
    {
        // Create a new local variable here
        SandBox sb = new SandBox();
        Dimension dime = sb.getPanelBounds();
        Rocket rock = new Rocket(dime.width/2, dime.height/2);
        sb.addBlob(rock); 
}