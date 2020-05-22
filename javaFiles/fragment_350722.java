for (int i = 0; i < 10; i++) {
        isFemale = false;//Set it here
        double random = RandomHelper.nextDoubleFromTo(0, 1);
        if (random > 0.33){
            isFemale = true;
            //...