// pass arguments to constructor like normal
B b = new A.B(str1, str2){
    @Override
    int deriveCalculatedData(){
        // your stuff
        return -1;
    }
};