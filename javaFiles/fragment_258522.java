public static void main(String args[]){
             //Initially value of count is 10
             StaticDemo t1=new StaticDemo(); //here it becomes 11
             StaticDemo t2=new StaticDemo(); //here it becomes 12

             StaticDemo.display(); //Now you are printing, it will print 12
             t2.display(); //The value has not changed, so again 12

          }