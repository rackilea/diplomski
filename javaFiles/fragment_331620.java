public class TaskTest extends AsyncTask<String, Integer, Boolean> {


    protected Boolean doInBackground(String... params) {

        Boolean StringNull = false;
         String subCode = params[0];

         if (subCode == null){
            StringNull = true;
         }

        return StringNull;

    }

    protected void onPostExecute(Boolean result) {
        if (!result) {
             System.out.println(subCode);
        } else {
            finish();
        }
    }
}