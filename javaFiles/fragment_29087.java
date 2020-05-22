import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class Answers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Json.txt"));
        String line;
        StringBuilder json = new StringBuilder();
        json.append("{\n\"");
        line = br.readLine();
        json.append(line.replace(" ", "").replace(":", "\":")
                + ", \n\"Content\":");
        while ((line = br.readLine()) != null) {
            if (!line.matches("\\[[0-1],"))
                if (!line.matches("\\}\\]\\]\\]"))
                    json.append(line.replace(" ", "") + "\n");
                else {
                    json.append("}]\n");
                }

        }
        json.append("}");
        String jsonstr = json.toString();
        Gson gson = new Gson();
        HttpResponse myModel = (HttpResponse) gson.fromJson(jsonstr, HttpResponse.class);
        System.out.println(gson.toJson(myModel));
        br.close();

    }

    class HttpResponse {

        @SerializedName("ResponseCode")
        private int responseCode;
        @SerializedName("Content")
        private List<User> content;


        class User {
            private String uid;
            private String state;
            private String uname;
            private String ulv;
            private String ujob;
            private String sex;
            private String zhanli;
            private String tempscore;
            private String score;
            private String pos;
            private String totalscore;
            private String tsleave;
        }

    }

}