public AWTApp(String caption)
    {
        super(caption); // here you are calling super constructor the frame constructor and creating the frame

       this.setLayout(new GridLayout(PANELS_NO, 1)); // cause you are a frame you can call with this parents public protected (and package if they are in the same package)
       this.add(..); 
    }
}