public void setSize(String sz){
    size = sz;
    if(size.equals("XXXL") || size.equals("XXL"){
        price = 22.99;
    }else{
        price = 19.99;
    }
}