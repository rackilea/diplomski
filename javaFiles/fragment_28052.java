//initial exponential function check
int baseNum = 2;
final int exponent = 3;
int check = Math.pow(baseNum, exponent);
for(int x = 1; x <= 100; x++){
    if(x == check){
        System.out.println(x);
        baseNum++;
        check = Math.pow(baseNum, exponent);
    }
}