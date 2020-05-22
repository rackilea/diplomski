class Seasons {
    private static Map<String,String> map = new HashMap<>();
    static {
        map.put("Skyrise", "Skyrise");
        map.put("Toss_Up", "Toss%20Up");
    }
    public static String getFormatted(String key){
        return map.getOrDefault(key,"");
    }
}
class main{
    public static void main(String[] args) {
        System.out.println(Seasons.getFormatted("Skyrise"));
    }
}