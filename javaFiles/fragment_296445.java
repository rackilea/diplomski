for (String string : query.split(" ")) {
        if(string.contains("_DATA_"))
        {
            System.out.println(string); // USER_DATA_SIGNIN
            System.out.println(string.split("_")[0]); // USER
        }
    }