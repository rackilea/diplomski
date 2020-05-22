public class MapLoader {

    private static MapLoader map;



    public static MapLoader getInstance(){
        if(map== null){
            map= new MapLoader ();
        }
        return map;
    }
}