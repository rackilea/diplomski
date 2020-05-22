public static void main(String[] args){
//The default value you want
int number = 2048
if(args.length==2){
    number = Integer.parseInt(args[1]);
}
//'number' will have the number the user specified or the default value (2048) if the user didn't specify a number
}