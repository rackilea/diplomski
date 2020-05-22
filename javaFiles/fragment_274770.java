private checkNumbers checkobj;

public int add(int a, int b){
    boolean flg = checkobj.check(a, b);

    if(flg == true){

        return a+b;
    }else{

        return 0;
    }
}