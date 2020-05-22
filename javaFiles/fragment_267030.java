int x;
x = -1;
if (x < 0) { //-1 < 0 = true
    x = 1;   //enter here -> change x = 1
}//end of the first if

if (x >= 0) {//1 >= 0 = true
    x = 2;   //enter here -> change x = 2
}//end of the second if

System.out.println(x);//result is 2