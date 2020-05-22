SandBox sb; // Declare SandBox as instance/class variable
    public static void main(String[] args) 
        {
            new AsteroidGame();
        }

        public AsteroidGame()
        {      
            //Create SandBox
            sb = new SandBox();
            sb.init(this);
        }

        public void generate() 
        {
            //Instantiate Rocket and add it to Sandbox
            Dimension dime = sb.getPanelBounds();
            Rocket rock = new Rocket(dime.width/2, dime.height/2);
            sb.addBlob(rock); 
    }