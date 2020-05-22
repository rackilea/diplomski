import com.google.gson.Gson;
        public class JsonParser {
            public static void main(String[] args){
                Gson gson = new Gson();
                String yourJson = "";
                MainObject object = gson.fromJson(yourJson, MainObject.class);
            }
        }