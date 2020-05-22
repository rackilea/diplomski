public Handler handler;

handler = new Handler() {
    @Override
    public void handleMessage(android.os.Message msg) {
        if (msg.what == YOUR_INT_MESSAGE) {
            int i=0;
            IntegerResult = msg.obj;
            while (!fileparts.isEmpty()  ) { //&& !fileparts1.isEmpty() && (flag == false) 
                String[] myStringArray = new String[IntegerResult];
                for (int e=0; e<IntegerResult; e++){
                     if (fileToReceive != null && !fileparts.isEmpty() ){
                         fileToReceive = fileparts.peek();
                         myStringArray[e] =  fileToReceive;
                         fileToReceive = fileparts.remove();
                     } else {
                         myStringArray[e] =  " ";
                 }
                 System.out.println("myStringArray["+e+"] " + myStringArray[e]);
             }
        }
    }
}