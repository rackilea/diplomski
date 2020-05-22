if(isInCircle(mouseLocation,circX+circW/2,circY+circH/2,circW/2)){
            float red = rand.nextFloat();       //generates a random value for the red tint value
            float green = rand.nextFloat();
            float blue = rand.nextFloat();
            circleColor = new Color(red, green, blue);
        }