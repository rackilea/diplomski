if (obj.containsKey("children")) {
        try {
            childrens = (JSONArray) obj.get("children");

            // call to recursive function to find nested children array 
            //and print url
            printUrls(childrens);
        } catch (Exception e) {
          // try-catch to handle any unexpected case
         }
    }