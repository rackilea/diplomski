JsonElement parse = (new JsonParser()).parse(response); //found this in internet


    int bound = ((JsonArray)parse).size(); // Should be 4

    for (int i = 0; i < bound; i++) {
        String data = ((JsonArray)parse).get(0).getAsString();
        if (data.equals("connected") || data.equals("disconnected")) {
            System.out.println(data);
            continue;
        }
        String[] splittedData = data.split(":");
        if (splittedData.length
                == 2) {// to check how many strings there is, if it's ["abc","def"] or ["abc"]
            System.out.println(splittedData[0] + " says: " + splittedData[1]);
        }
        /*
        *else{
        * your else logic goes here
        * }
         *  */
    }

}