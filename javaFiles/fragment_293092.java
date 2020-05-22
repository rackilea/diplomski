public static void getString() {
    String str = "f:   (matchQuan " +
                      "(Recipe "+
                      "(Unique FoodType" + " slurpee"+ " xxx-xxx-eee-ddd"+
                      "(Unique IngredType"+ " slurpee"+ " qqq-rrr-sss"+" slurpee" +
                       " (Cup - Vol 12)).";
    String newStr=str.replaceAll("\\(","").replaceAll("\\)","");
    String[] arrStr=newStr.split(" ");
    for (int i=0;i<arrStr.length;i++){
        System.out.println(arrStr[i]);
    }

}