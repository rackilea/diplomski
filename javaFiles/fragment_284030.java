import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

GsonBuilder gsonBuilder = new GsonBuilder();
Gson gson=gsonBuilder.create();
gson.fromJson(<return type>,<expected type>);