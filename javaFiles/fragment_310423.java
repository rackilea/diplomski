public class CountPhrases {
    public static void main(String[] arg){
        String input = "my name is john jane doe jane doe doe my name is jane doe doe my jane doe name is jane doe I go by the name of john joe jane doe is my name";

        String[] split = input.split(" ");
        Map<String, Integer> counts = new HashMap<String,Integer>(split.length*(split.length-1)/2,1.0f);
        int idx0 = 0;
        for(int i=0; i<split.length-1; i++){
            int splitIpos = input.indexOf(split[i],idx0);
            int newPhraseLen = splitIpos-idx0+split[i].length();
            String phrase = input.substring(idx0, idx0+newPhraseLen);
            for(int j=i+1; j<split.length; j++){
                newPhraseLen = phrase.length()+split[j].length()+1;
                phrase=input.substring(idx0, idx0+newPhraseLen);
                Integer count = counts.get(phrase);
                if(count==null){
                     counts.put(phrase, 1);
                } else {
                     counts.put(phrase, count+1);
                }
            }
            idx0 = splitIpos+split[i].length()+1;
        }

        Map.Entry<String, Integer>[] entries = counts.entrySet().toArray(new Map.Entry[0]);
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