public String flip(){
    Random randomNum = new Random();
    int result = randomNum.nextInt(2);
    if(result == 0){
        return "RG";
    } else {
        return "NP";
    }
}