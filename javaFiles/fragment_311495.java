public static void main(String args[]){
        String word = "----------";
        word = putCharAtPlaces(word,'a',new int[]{0,2,3});
        System.out.println(word);
    }

    private static String putCharAtPlaces(String word,char c, int[] is) {
        StringBuilder stringBuilder = new StringBuilder(word);
        for(int place:is){
            stringBuilder.setCharAt(place, c);
        }
        return stringBuilder.toString();
    }