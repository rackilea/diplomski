WP.add("A");
    WP.add("B");
    WPL.add(WP);    

    WP.clear();  //this also clears the values in WPL since WPL doesn't store A and B, it stores a reference to WP.

    WP.add("C");
    WP.add("D");
    WPL.add(WP);