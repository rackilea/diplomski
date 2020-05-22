boolean isNeeded(String name, Derived1 item) { 
   return callMethodDoSomething(
        item.getData().getSpecificData());
}

boolean isNeeded(String name, Derived2 item) { 
   return callMethodDoSomething(
        item.getData().getSpecificData());
}