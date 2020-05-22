static int rolldice(){
    double randomnum=Math.random();
    randomnum=randomnum*6;
    randomnum=randomnum+1;
    int randomint =(int) randomnum;
    return randomint;        
}
public static void main(String[] args) {    

}

public static int roll(){

    int roll1= rolldice();
    int roll2=rolldice();
    int count=1;
    while(!(roll1==roll2)) {
        roll1=rolldice();
        roll2=rolldice();
        count=count+1;

    }
    return count;
}