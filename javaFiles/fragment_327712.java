import org.json.JSONArray;
import org.json.JSONObject;

public class JSONBuilderMinecraft {

    public static void main(String args[]) throws Exception{

        JSONObject mainJson = new JSONObject();



        //inner most json array
        JSONArray itemarray=new JSONArray();

        //inner most json
        JSONObject itemsJson= new JSONObject();
        itemsJson.put("item", "minecraft:elytra");
        itemsJson.put("data", 1);
        itemarray.put(itemsJson);

        JSONObject conditions = new JSONObject();
        conditions.put("items", itemarray);


        JSONObject elytra = new JSONObject();
        elytra.put("trigger", "minecraft:inventory_changed");
        elytra.put("conditions", conditions);


        mainJson.put("criteria", elytra);
        mainJson.put("parent", "minecraft:story/enter_end_gateway");

        JSONObject icon = new JSONObject();
        icon.put("item", "minecraft:elytra");

        JSONObject display = new JSONObject();
        display.put("title", "Learn to Fly");
        display.put("icon", icon);

        mainJson.put("display", display);

        System.out.println(mainJson.toString());

    }


}