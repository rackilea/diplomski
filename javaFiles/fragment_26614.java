for (String noResponse : responses  ){
        if (response.equals(noResponse)) { // you can also use .contains if you 
                                           // don't require an exact match
            System.out.println("You said no");
            break;
        }
    }