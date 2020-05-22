public void listArray(){
    textarea1.setText("");
    for (int X=0;X<MYARRAY.length;X++){
        if(MYARRAY[X] != null)
            textarea1.append(MYARRAY[X]+"\n");
    }
}