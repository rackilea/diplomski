public class RestaurantMenuHolder{

    private static RestaurantMenuHolder mInstance = null;
    public static ArrayList<RestaurantMenuObject> restaurantMenu;

    public static RestaurantMenuHolder getInstance(ArrayList<RestaurantMenuObject> restaurantMenu){
        if(mInstance == null){
            mInstance = new RestaurantMenuHolder(restaurantMenu);
        }
        return mInstance;
    }

    public static RestaurantMenuHolder getInstance(){
        if(mInstance == null){
            mInstance = new RestaurantMenuHolder(restaurantMenu);
        }
        return mInstance;
    }

    private RestaurantMenuHolder(ArrayList<RestaurantMenuObject> restaurantMenu){
        this.restaurantMenu = restaurantMenu;
    }

    public static int getCount(){
        return restaurantMenu.size();
    }

}