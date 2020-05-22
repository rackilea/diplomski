public boolean isPalindrome(){

    char[] text1 = new char[this.text.length()];

    for(int i = 0; i< this.text.length(); i++){
       text1[i] = this.text.charAt(i);
    }
    char[] text2 = new char[this.text.length()];
    int j = 0;
    for(int i = this.text.length()-1; i >=0; i--){
       text2[j] = this.text.charAt(i);
       j++;
    } 

    for(int i = 0; i < this.text.length(); i++){
       if(text2[i]!=text1[i]){
          return false;
       }
    }
    return true;
}