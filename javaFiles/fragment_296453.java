public char[][] to2DChars(String words){

  int row=0;
    int index=words.indexOf(' ');
    int col=(index==-1 ? words.length() : index);
    while(index!=-1){
    row++;
    index=words.indexOf(' ',index+1);
    }
    row++;
    char[][] c=new char[row][col];
    int k=0;
    for(int i=0;i<row;i++){
    for(int j=0;j<col;j++){
    c[i][j]=words.charAt(i+k);
    k++;
    }