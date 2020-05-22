public  void changeArrayValues(){
    int arrayPosition = 0;
    while(arrayPosition < array.length){
           if(array[arrayPosition][1] != null && Integer.parseInt(array[arrayPosition][1].trim()) == 0){
                String userID = array[arrayPosition][0].trim();
                for(int i = 0; i < array.length; i++){
                    if(array[i][0] != null && array[i][0].trim().equals(userID)){
                        array[i][0] = "";
                    }
                }
            }else if (array[arrayPosition][0] != null && !array[arrayPosition][0].equals("")) {
                String userID2 = array[arrayPosition][0].trim();
                int min = Integer.parseInt(array[arrayPosition][1].trim());
                for (int j=0;j<array.length;j++){
                    if (array[j][0] != null && array[j][1] != null){
                        if(array[j][0].equals(userID2) && Integer.parseInt(array[j][1].trim()) < min){
                            min = Integer.parseInt(array[j][1].trim());
                            array[arrayPosition][0] = "";
                        } else if (array[j][0].equals(userID2) && Integer.parseInt(array[j][1].trim()) > min)
                            array[j][0] = "";
                    }
                }
         }

        arrayPosition++;
    }
}