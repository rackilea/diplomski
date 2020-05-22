Arrays.sort(actualViews);
Arrays.sort(xviews);
boolean equal = true;
for(int i=0;i<actualViews.length && equal;i++) {
    if(!actualViews[i].equals(xviews[i]) {
        equal = false;
    }
}
if(equal) {
   System.out.println("=> The both String Arrays data is equal...");
} else {
   System.out.println("=> The both String Arrays data is NOT equal...");
}