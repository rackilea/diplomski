import java.utils.List;
import java.utils.Arrays;

Class Categories { 

    private final statis Categories categories = null;

    private Map<String, List<String>> subCategories = null;

    private Categories() { 
        subCategories = new HashMap<>();
        subCategories.put("eletronics", Arrays.asList("mobiles", "TV", "iPod"));
    }

    public static Categories getInstance() {
        if (categories == null) { 
            categories = new Categories();
        }
        return categories;
    }

    public static getSubCategories(String category) {
        return subCategories.get(category);
    }
}