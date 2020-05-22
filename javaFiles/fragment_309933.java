private String getSubstitute(String label) {
        if (listMap.get(label) != null){
            String substitute = randomFrom(listMap.get(label));
            listMap.get(label).remove(substitute);
            return substitute;
        }
        if (label.equals("number")){
            return " " + myRandom.nextInt(50) + 5;
        }
        return "**UNKNOWN**";
     }