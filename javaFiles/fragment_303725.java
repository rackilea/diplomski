class FactoryOfFactory {

   enum Type { P1, P2}

   public AbstractProductA createProductA(Type t) {
        switch(t) {
            case P1:
               return new ConcreteFactory1().createProductA();
            case P2:
               return new ConcreteFactory2().createProductA();
            ....
        }
   }

   public AbstractProductB createProductB(Type t) {
         switch(t) {
            case P1:
               return new ConcreteFactory1().createProductB();
            case P2:
               return new ConcreteFactory2().createProductB();
            ....
        }
   }

}