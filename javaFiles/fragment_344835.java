public class GsonPlay {


    public static void main(String args[]) {

        String testString = "[{\"id\": \"1\",\"name\": \"test1\",\"childrens\": [{\"id\": \"14\",\"name\": \"test2\",\"childrens\": []}]}]";
        List<Model> modelList = parseJsonService(testString);
        System.out.println(modelList);
    }

    private static List<Model> parseJsonService(String testString) {
        Gson gson = new Gson();
        Model[] models = gson.fromJson(testString, Model[].class);
        return Arrays.asList(models);
    }
}
class Model {
    private int id;
    private String name;
    private List<Model> childrens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Model> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Model> childrens) {
        this.childrens = childrens;
    }
}