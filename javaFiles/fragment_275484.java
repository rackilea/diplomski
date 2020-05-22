public class Food {

    private Boolean isEdible() {
        return true;
    }

    public static void main(String[] args) {
        Food food = new Food();
        try {
            Class<?>[] methodArgumentTypes = null; // {};
            Object[] methodArguments = null; // new Object[0];
            Method method = food.getClass().getDeclaredMethod("isEdible", 
                    methodArgumentTypes);
            System.out.println(method.invoke(food, methodArguments));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}