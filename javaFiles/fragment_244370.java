public boolean equals(){
if(array.size()!=array1.size) return false; // test for different length
for(int i = 0; i < array1.size(); i++){
    if(!array1.get(i).equals(array.get(i))){
        return false;
    }       
 }
 return true;
}