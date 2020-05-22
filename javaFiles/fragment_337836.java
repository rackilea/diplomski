for(int i=0;i<actualViews.length;i++) {
    boolean equal = false;
    for(int j=0;j<xviews.length;j++) {
        if(actualViews[i].equals(xviews[j])) {
            equal = true;
            break;
        }
    }
    if(equal) {
       System.out.println("=> '"+actualViews[i]+"' is there in the other array...");
    } else {
       System.out.println("=> '"+actualViews[i]+"' is NOT there in the other array...");
    }
}