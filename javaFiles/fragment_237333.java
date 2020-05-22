String myString = "A1A2A3A4A5A6A7A8A9";
    StringBuilder str = new StringBuilder(myString);
    for(int i = 0; i < str.length(); i++){
        if(i == 6){
            str.insert(i, "-");
        }
        if(i == 13){
            str.insert(i, "-");
        }
    }
    System.out.println(str.toString());