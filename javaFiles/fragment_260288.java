if (fieldname.equals("multipleSelect")){
    String[] valueArray = value.split(","); //split string by ,
    //do your array stuff here, for example
    for (String individualValue: valueArray ) {           
        //play with individual dropdown item here, for example
        System.out.println(individualValue);
    }
}