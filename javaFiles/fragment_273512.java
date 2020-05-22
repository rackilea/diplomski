@Service
public class MyClassA {

        @Autowired
        private Provider<MyClassB> myClassB;

        public String findMydata(String input) {
            MyClassB classB = myClassB.get(); 
            String myData = classB.getSomeData(input);    
            return myData;
        }
}