enum MyEnum  { 
      ONE(1.0), TWO(2.0), THREE(3.0); 

      private double myDouble; 

      MyEnum(double d) {  
          myDouble = d;
      }

      public double getDouble() {
          return myDouble;
      }
}