import java.util.ArrayList;
 import java.util.List;
   class Test{

        private List<MyClass> getResources() {
            // TODO Auto-generated method stub
                // Use your business logic over here
              ----------------------------------
            return new ArrayList<MyClass>();
        }
        // This is your method which will returns all the names
        public List<String> getAllNames(){
            List<String> names = new ArrayList<String>();
            List<MyClass> items = getResources();
            for (MyClass myClass : items) {
                names.add(myClass.getName());
            }
            return names;
        }
    }