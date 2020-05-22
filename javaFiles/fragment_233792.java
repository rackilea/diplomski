public class Mapper{

    // private static Map<Model, String> models= new HashMap<>();        
    private static Map<Object, String> models= new HashMap<>();

    static {
        models.put(Model.IMAGE_JPG, MediaType.IMAGE_JPEG_VALUE);
        models.put(Model.IMAGE_GIF, MediaType.IMAGE_GIF_VALUE);
    }

    // public static String createModelMap(Model model) {
    public static String createModelMap(Object model) {
        if (models.containsKey(model)) {
            return models.get(model);
        } else {
            throw new ModelException("Exeception");
        }
    }
}