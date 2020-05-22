public int findday(int month, int day, int year){
    int i = 0;
    int days=0;
    while(i<month) {
        if(i==0){days += 31;}
        if(i==1){days += 28;}
        if(i==2){days += 31;}
        if(i==3){days += 30;}
        if(i==4){days += 31;}
        if(i==5){days += 30;}
        if(i==6){days += 31;}
        if(i==7){days += 31;}
        if(i==8){days += 30;}
        if(i==9){days += 31;}
        if(i==10){days += 30;}
        if(i==11){days += 31;}
        i++;
    }
    if(year%4==0){ if(month>2){days+=1;} }
    return days + day;
}