class outer {
    public void printInner() {
        // accessible in the same .java file because we made it private
        inner i = new inner();
        i.showInner(); // what should `x` be?
    }

    public void outerfunction(final int x) {    
         private class inner { // Line-1
              public void showinner() {
                  System.out.println("I am in Inner Class, x= " + x);    
              }
          }    
    }
}