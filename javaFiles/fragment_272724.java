public class test {
    public static void main(String args[]){
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<>();
        map1.put("Name", "Jerry");
        map1.put("State", "Texas");
        map2.put("Name","TOM");
        map2.put("State", "Texas");
        Iterator<?> it = map1.entrySet().iterator();
        Iterator<?> it1 = map2.entrySet().iterator();
        while (it.hasNext() && it1.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            Map.Entry pair1 = (Map.Entry)it1.next();
            if(!pair.getValue().equals(pair1.getValue())) {
                System.out.println(pair.getKey()+" "+pair.getValue()+" "+pair1.getValue()+" mismatched");
            }
        }
    }
}