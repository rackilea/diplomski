String[] food = {"Pizza", "Burger", "Pasta", "Hot Dog", "etc"};

JCheckBox[] boxes = new JCheckBox[food.length]; //  Each checkbox will get a name of food from food array.  

for(int i = 0; i < boxes.length; i++)
    boxes = new JCheckBox(food[i]);