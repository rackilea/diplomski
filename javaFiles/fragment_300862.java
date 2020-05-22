public String getPos(int id){
String res = "";
for(int i = 0; i <9 ;i++ ){
    for(int j = 0; j<5 ;j++){
        if(this.arr[i][j] == id)
              res = res +"["+ (i+1) + "," + (j+1)+"]";  
    }
}
return res;