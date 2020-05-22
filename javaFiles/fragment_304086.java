int given_color=0x00033202;//3,50,2 in ARGB form in hex
int relative_max=(given_color&0xff);//not 200, default assume blue is max
int relative_min=(given_color&0xff);//not 200, default assume blue is min
int tmp;
for(int a=8;a<=16;a+=8){//check for red and green too
 tmp=(given_color>>a)&0xff;
 if(tmp<relative_min){relative_min=tmp;}
 if(tmp>relative_max){relative_max=tmp;}
}//now you have max and min of given color, here 50 and 2
//now assume the 74% of real max value is const val 200
//and the value you want to check for color
relative_max*=0.74;
relative_min*=0.74;
//now check over real amx and rel min over const values
if( (r<relative_min) && (g>relative_max) && (b>relative_max) ){}//could be cyan
//...etc