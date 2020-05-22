public class CountPhrases {
    public static void main(String[] arg){
        String input = "my name is john jane doe jane doe doe my name is jane doe doe my jane doe name is jane doe I go by the name of john joe jane doe is my name";

        String[] split = input.split(" ");
        Map<String, Integer> counts = new HashMap<String,Integer>();
        for(int i=0; i<split.length-1; i++){
            String phrase = split[i];
             for(int j=i+1; j<split.length; j++){
                phrase += " " + split[j];
                Integer count = counts.get(phrase);
                 if(count==null){
                     counts.put(phrase, 1);
                 } else {
                     counts.put(phrase, count+1);
                 }
             }
        }

        Map.Entry<String,Integer>[] entries = counts.entrySet().toArray(new Map.Entry[0]);
        Arrays.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int rank=1;
        System.out.println("Rank Freq Phrase");
        for(Map.Entry<String,Integer> entry:entries){
            int count = entry.getValue();
            if(count>1){
                System.out.printf("%4d %4d %s\n", rank++, count,entry.getKey());
            }
        }
    }
}