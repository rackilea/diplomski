public boolean equal(char[] s, char[] t, int n) {

    //TODO: you can add checks to make sure n is less than the length of both of the arrays

    for(int i = 0; i < n; i++){

        //For the first n elements, if they aren't equal just return false;
        if(s[i] != t[i]){

            return false;
        }
    }
    return true;
}