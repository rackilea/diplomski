public int lastIndexOfUCL(String str) {        
    for(int i=str.length()-1; i>=0; i--) {
        if(Character.isUpperCase(str.charAt(i))) {
            return i;
        }
    }
    return -1;
}