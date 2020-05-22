public static void main(String[] args) {

    /*Get your strings into an Array*/
    String[] str = {"Type:Carro;high:4,66;model:fourDoors;birthday:01/01/1980",
                    "type:Truck;high:5,66;model:twoDoors;birthday:29/05/1977",
                    "tYpe:motorcycle;high:1,55;model:fiveDoors;birthday:01/01/1980",
                    "type:Carro;high:4,66;type:model;birthday:6/12/1887",
                    "type:Carro;high:9,66;model:Doors;birthday:05/12/2010",
                    "Expected OutPut:",
                    "Type:Carro;high:4,66",
                    "type:Truck;high:5,66",
                    "tYpe:motorcycle;high:1,55",
                    "type:Carro;high:4,66",
                    "type:Carro;high:9,66"
    };
    /*Create a "final staging" array*/
    String[] newStr = new String[str.length - 1];

    for (int j = 0; j < str.length - 1; j++) {//For each of your strings
        str[j] = str[j].toLowerCase();//set the string to lower

        /*If they don't contain a semi-colon and a model or birthday reference go to else*/
        if (str[j].contains(";") && str[j].contains("model") || str[j].contains("birthday")) {
            /*Otherwise, split the string by semi-colon*/
            String[] sParts = str[j].split(";");

            String newString = "";//the new string that will be created

            for (int i = 0; i < sParts.length - 1; i++) {//for each part of the sParts array

                if (sParts[i].contains("model") || sParts[i].contains("birthday")) {//if it contains what is not desired
                    //Do Nothing
                } else {
                    newString += sParts[i];//otherwise concatenate it to the newString
                }

                newStr[j] = newString;//add the string to the "final staging" array
            }
        } else {

            newStr[j] = str[j];//if it didn't have semi-colons and birthday or model, just add it to the "final staging" array

        }

    }

    for (String newS : newStr) {// finally if you want to see the "final staging" array data... output it.

        System.out.println(newS);

    }

}