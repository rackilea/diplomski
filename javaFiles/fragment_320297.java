public static void permute(String soFar, String strLeft) {

    if(strLeft.length() == 1) {
        soFar += strLeft;
        System.out.println(++count + " :: " + soFar);
    }
    else {
        for(int i=0; i<strLeft.length(); i++) {
            permute(soFar + strLeft.charAt(i), strLeft.substring(0,i) + strLeft.substring(i+1));
        }
    }
}