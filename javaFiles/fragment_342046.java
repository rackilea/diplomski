doFunc(numbers, new IFunction() { 
        public void execute(Object o) { 
           Integer anInt = (Integer) o; 
           anInt++;
           System.out.println(anInt);
        } 
    });