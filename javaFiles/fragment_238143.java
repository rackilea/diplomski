import android.os.Build;
import android.support.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpRequestDietPlan {

    private  OkHttpClient client = new OkHttpClient();

    public interface CallHandler {
        public void onSuccess(DietPlan dietPlan);
        public void onFailure(Exception e);
    }

    public void getJson(CallHandler callHandler) {

        final Request request = new Request.Builder()
                .addHeader("X-RapidAPI-Host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", "KEY_KEY_KEY")
                .url("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/mealplans/generate?timeFrame=day&targetCalories=2000")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                call.cancel();
                e.printStackTrace();
                callHandler.onFailure(e)
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    IOException e = new IOException("Unexpected code " + response);
                    callHandler.onFailure(e)
                } else {
                    DietPlan dietPlan = new DietPlan();
                    // Deserialize with a library here 
                    try {
                        String jsonData = response.body().string();
                        JSONObject json = new JSONObject(jsonData);
                        JSONArray arrayMeals = json.getJSONArray("meals");

                        for (int i = 0; i < arrayMeals.length(); i++) {
                            JSONObject object = arrayMeals.getJSONObject(i);
                            Meal meal = new Meal(
                                object.getInt("id"),
                                object.getString("title")
                            );
                            dietPlan.meals.add(meal);
                            System.out.println(meal);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    callHandler.onSuccess(dietPlan)
                }
            }
        });
    }
}