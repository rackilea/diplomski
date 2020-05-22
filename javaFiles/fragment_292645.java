...
     public Main(){
         Save saveObject = new Save();
         saveObject.field = new JTextField(12);
         saveObject.button = new JButton("Click");
         add(saveObject.field);
         add(saveObject.button);
         this.save = saveObject;//assuming you have a class field of type Save named "save"   
...