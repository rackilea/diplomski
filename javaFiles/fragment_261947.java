while(tbody != null){

    Elements elements = tbody.select("tr");

    if(!elements.isEmpty()){

        Element tr = temp.get(j);

        if(tr != null){
            if(string == "A"){
                //Do something
            }
            j = j + 1; //Increment for looking for the next "tr"
        }

    }

}