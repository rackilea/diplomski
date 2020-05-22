public class ContainsKeyIgnoreCase {

    public static void main(String[] args) {

        Map<String, Integer> userInfo = new HashMap<String, Integer>();
        userInfo.put("nickNamE", 1);

        String nickName = "NiCKname";

        System.out.println(containsKeyIgnoreCase(userInfo, nickName));
    }

    public static boolean containsKeyIgnoreCase(Map<String, Integer> map, String lookupKey) {
        return map.keySet()
                  .stream()
                  .map(key -> key.equalsIgnoreCase(lookupKey))
                  .reduce(false, Boolean::logicalOr);
    }   
}