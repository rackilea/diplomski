package stackoverflow.questions.q19332412;

import com.google.gson.*;

public class Q19332412 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String j1 = "{\"width\":4, \"height\":5, \"depth\"=1}";
        String j2 = "{\"w\":4, \"h\":5, \"d\"=1}";

        GsonBuilder gb = new GsonBuilder().registerTypeAdapter(Box.class, new BoxAdapter());
        Gson g = gb.create();
        System.out.println(g.fromJson(j1, Box.class));
        System.out.println(g.fromJson(j2, Box.class));
    }

}