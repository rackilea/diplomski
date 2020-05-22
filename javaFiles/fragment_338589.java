public class ForgotPasswordActivity extends AppCompatActivity 
                 implements View.OnClickListener,   
                                   AccountServiceCallback{

       private void submit() {
                AccountService.forgotPassword("email@123.com", this);
       }


       @Override
       public void onClick(View v) {

       }

      @Override
      public void onResponse(JSONArray response) {
             // UPDATE UI as per on response requirement
      }

      @Override
      public void onErrorResponse(VollyError error) {
             // UPDATE UI as per response flow
      }
}

public class AccountService {

    public static void forgotPassword(Context c, String email, final    
                       AccountServiceCallback callback) {

           String url = "myUrl";

           JsonArrayRequest request = new JsonArrayRequest(url,
                            new Response.Listener<JSONArray>() {
                      @Override
                      public void onResponse(JSONArray response) {
                             // done
                             callback.onResponse(response);
                      }
            }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
                callback.onErrorResponse(error);
           }
       });

      Volley.newRequestQueue(c).add(request);

     }

   interface AccountServiceCallback {
       public void onResponse(JSONArray response);
       public void onErrorResponse(VollyError error);
   }
 }