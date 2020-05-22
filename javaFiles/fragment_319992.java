public class Connector extends AsyncTask<String,Void,String>{
    private OnPostExecuteListener onPostExecuteListener;
     /**
     * The callback interface
     */
    public interface OnPostExecuteListener {
        void onPostExecute(String result);
    }

    public void setOnPostExecuteListener(OnPostExecuteListener listener){
        this.onPostExecuteListener = listener;
    }

    @Override
    protected void onPostExecute(String result) {
       result = "{ \n \"Data\": \n " + result + " \n }";
       if(onPostExecuteListener !=null){
             onPostExecuteListener.onPostExecute(result);
       }
       this.setJSON(result);
    }

}