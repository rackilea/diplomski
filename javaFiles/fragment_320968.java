import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.naitiks.helpme.Model.HappyMomentsModel;
import com.naitiks.helpme.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Naitik on 25-04-2016.
 */
public class RestHelper {

    private RequestQueue queue = null;
    private Context context = null;

    public void setQueue(RequestQueue queue) {
        this.queue = queue;
    }

    public RequestQueue getQueue() {
        return queue;
    }

    public RestHelper(Context context){
        this.context = context;
        queue= Volley.newRequestQueue(context);
    }
    public JSONObject postRequestTest(String url, final JSONObject userMap,final RequestFuture requestFuture){
        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url, userMap,requestFuture,requestFuture);
        postRequest.setRetryPolicy(new RetryPolicy() {
            @Override
            public int getCurrentTimeout() {
                return 40000;
            }

            @Override
            public int getCurrentRetryCount() {
                return 5;
            }

            @Override
            public void retry(VolleyError volleyError) throws VolleyError {
            }
        });
        queue.add(postRequest);
        try {
            Object object = requestFuture.get();
            System.out.println("*** result" +object.toString());
            JSONObject result = (JSONObject)object;
            return result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}