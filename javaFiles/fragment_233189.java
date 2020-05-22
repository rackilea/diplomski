String str = "Google Plus style #ListViews are all 
              the rage these days on #Android because of the slick @animations.";
 String[] arr = str.split(" ");
    for (String i : arr) {
        if (i.startsWith("#")) {
            // do something for #
        } else if(i.startsWith("@")){
            // do something for @
        } else {
           // other text 
        }
    }