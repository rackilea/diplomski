public class Controller {
      actViewDB activity;
     public  void Controller(actViewDB activity){
            this.activity = activity;
        }
        public static void getData(){
            DataModel.getData();
        }

        public static void ifSuccess(List<DataModel> mUsername){

            activity.showDatabase(mUsername);
        }
    }