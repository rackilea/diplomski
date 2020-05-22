public Content (){
        int yLevel = (((int)Math.random())*(getHeight() / 4));
        int xPos = ((int)Math.random())*getWidth();
        for(int i = 0;!(i == 9); i++)   { 
             //Create the randomly located targets
            targets[i] = new Target(xPos, yLevel, xPos-15, yLevel-10);
        }

        instance = this; // added
    }