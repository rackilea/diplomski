//System.out.print("Input your desired length: ");
int length = 39;
//System.out.print("Input your desired width: ");
int width = 7;

for(int i=0; i<width; i++){
    for(int j=0; j<length; j++){
        if(i==j%width  || (i+j%width)%width==width-1){
            System.out.print("#");
        }else{
            System.out.print(" ");
        }
    }System.out.println();
}