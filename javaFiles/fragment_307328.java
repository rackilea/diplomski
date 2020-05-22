public static void displayWeek(int month, int week, int firstDay, int lastDay){
//status: almost working for every case. Only issue is the last week
//display the months one week at a time
switch (week){
    case 0:
        for (int b=0; b<firstDay; b++) {
            System.out.print("    ");
        }
        for (int d=1; d<8-firstDay; d++){
            System.out.print((d<10 ? "   " : "  ")  + d);
        }
        break;
    case 1:
        for (int d=8-firstDay; d<15-firstDay; d++){
            System.out.print((d<10 ? "   " : "  ")  + d);
        }
        break;
    case 2:
        for (int d=15-firstDay; d<22-firstDay; d++){
            System.out.print((d<10 ? "   " : "  ")  + d);
        }
        break;
    case 3:
        for (int d=22-firstDay; d<29-firstDay; d++){
            System.out.print((d<10 ? "   " : "  ")  + d);
        }
        break;
    case 4:
        if(lastDay == 28 && firstDay==0){
            System.out.print("                        ");
            break;
        }
        for (int d=29-firstDay; d<36-firstDay; d++){
            if(d<lastDay+1){
                System.out.print((d<10 ? "   " : "  ")  + d);
            }else{
                System.out.print("    ");
            }
        }
        break;
}
}