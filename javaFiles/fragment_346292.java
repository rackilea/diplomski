public class MySynonyms {
    public static boolean syn(String input, String word){
        RiWordnet wordnet = new RiWordnet();
        String[] poss = wordnet.getPos(word);
        boolean check = false;
        String[] synonyms = null;

        for (int j = 0; j < poss.length; j++) {
            synonyms = wordnet.getAllSynonyms(word, poss[j], 50);
            for (int i = 0; i < synonyms.length; i++) {
                //System.out.println(synonyms[i]);
            }
        }

        for(int i= 0; i<synonyms.length;i++){
            if(input.contains(synonyms[i])){
                check=true;
            }
        }
        return check;
    }
}