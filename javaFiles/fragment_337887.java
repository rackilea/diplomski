public class HashMapVsArrayOfHashMap {

    public static void main(String[] args){
        ArrayList<HashMap<String, String>> listOfMaps=new ArrayList<HashMap<String,String>>();
        for( int i=0;i<1000;i++){
            final int finalI=i;
        listOfMaps.add(new HashMap<String, String>(){{put("asdfasdfasdfasdfadsf"+finalI,"asdfsdafasdfsadfasdf"+finalI);}});
        }
        LinkedHashMap<String, String> map=new LinkedHashMap<String, String>();
        for(int i=0;i<1000;i++)
            map.put("asdfasdfasdfasdfadsf"+i,"asdfsdafasdfsadfasdf"+i);     
        int position=700;
        testArrayList("Method1:ArrayListOfHashMaps",position,listOfMaps);
        testHashMap("Method2:LinkedHashMap",position,map);
    }

    private static void testArrayList(String string, int position,
            ArrayList<HashMap<String, String>> listOfMaps) {
        long start, end;
        start=System.nanoTime();
        listOfMaps.get(position).get("asdfasdfasdfasdfadsf"+position);
        end=System.nanoTime();
        System.out.println(string+"|Difference = "+(end-start));        
    }
    private static void testHashMap(String string, int position,
            LinkedHashMap<String, String> map) {
        long start, end;
        start=System.nanoTime();

        String s= new ArrayList<String>(map.keySet()).get(position);

        end=System.nanoTime();
        System.out.println(string+"|Difference = "+(end-start));        
    }
}