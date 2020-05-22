try{
        t.setBranchID("xxx");
        t.setCashOnHand("xxx");
        //Other methods
    } catch (NumberFormatException ex){
        if (ex.getMessage().startsWith("setBranchID")) {
            System.out.println("error from setBranchID method");
        }
        .....
    }