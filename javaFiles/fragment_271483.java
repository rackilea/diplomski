public class DataTransferrer {

        private static final DataTransferrer instance = new DataTransferrer();

        private ArrayList<Transients> transientList = new ArrayList<>();

        //private constructor, so instantiation NOT allowed
        private DataTransferrer() {}

        public static synchronized DataTransferrer getInstance(){
          return instance;
        }

       public ArrayList<Transients> getTransients(){
           return this.transientList;
       }

        public void setTransients(ArrayList<Transients> t){
            transientList = t;
        }

        public void printAll(){
            for(Transients t : transientList){
                Log.d("DEBUG DA",t.getDa().toString());
            }
        }
 }