if (!extension.equals("")) {
if (extension.contains(",")) {
    query = query.concat(" and (extension='");
    String extn[] = extension.split(",");
    for(int k=0; k <extn.length; k++){
    if(extn[k].contains("-")){
        String subExtn[] = extn[k].split("-");
        for (int i = 0; i < subExtn.length; i++) {
            //System.out.println(subExtn[i]);
            query = query.concat(subExtn[i]).concat("'").concat(" or extension='");

        }

    }else{
        //for (int i = 0; i < extn.length; i++) {
           // System.out.println(extn[i]);
            query = query.concat(extn[k]).concat("'").concat(" or extension='");
          //  System.out.println(query);
        //}
    }
    //System.out.println(query);
    }
    query = query.substring(0, query.length() - 15);
   // System.out.println(query);
    query = query.concat(")");
    System.out.println(query);
} else if (extension.contains("-")) {
    query = query.concat(" and cast(extension as signed) >=");
    String extn[] = extension.split("-");
    for (int i = 0; i < extn.length; i++) {

        query = query.concat(extn[i]).concat(" And cast(extension as signed) <=");

    }
    query = query.substring(0, query.length() - 33);
    System.out.println(query);

} else {
    query = query.concat(" and extension='" + extension).concat("'");
    System.out.println(query);
}
}