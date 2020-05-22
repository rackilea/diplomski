public static int NextBday(int Bdays, int days){
int daysleft = 0;
     if (days > Bdays) {
        daysleft= (365+Bdays) - days;
    }else if(Bdays > days){
        daysleft= Bdays-days;            
    }

    if (Bdays == days + 1) {
        System.out.println("\nWow, your birthday is tomorrow!");
    }else if (Bdays == days){
        System.out.println("\nHappy birthday!");
    } else
       System.out.println("\nYour birthday is in " +daysleft+ " days");
return daysleft;