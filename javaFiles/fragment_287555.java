MyObject myObject = new MyObject(){
            public MyObject open(){
                // do some stuff
                return this;
            }
            public MyObject dis(){
                // do some stuff
                return this;
            }
        };
myObject.open().dis();  //not compiling since anonymous class creates a subclass of the class