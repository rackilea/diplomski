for(int j=0;j<charArr.length;j++){
    if(letter == charArr[j]){
        dash[j] = letter;
        System.out.println("Ok ! ");
        System.out.println(dash);
        i--;                           // What is this doing here?
    }
}