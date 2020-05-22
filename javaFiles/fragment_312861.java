while(sc.hasNext()){
    String userName="",userLastName="",userCash="",paidStatus="";

    //first one already checked in while(...)
    userName = sc.next();

    if(sc.hasNext())        
        userLastName = sc.next();

    if(sc.hasNext())
        userCash = sc.next();

    if(sc.hasNext())
        paidStatus = sc.next();

    //... rest of code