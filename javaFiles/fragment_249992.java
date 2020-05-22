public class Tester {

    public static void main(String[] args) {

        Module.CATEGORY comm = Module.CATEGORY.LIGHTS;
        Gson gson = new Gson();

        String json = gson.toJson(comm);
        if (gson.fromJson(json, Module.CATEGORY.class) == Module.CATEGORY.LIGHTS)
            System.out.println("It works!");

    }
}