int yourValue = -1;

// Loop
for(i = 0;i <= numOfDays;i++){
    System.out.print("(" + i + ") " + total+ "   ");
    total = total -5;
    //yourValue will only be filled the first time total is below 40
    if (total < 40 && yourValue == -1) yourValue = i;
    if (total<=20){
        System.out.print("\nBecause mark drops below 20, mark stays as 20. final mark="+ finalMark);
        break;
    }

}   // End

if (yourValue > -1) System.out.print("\nThis work can be up to " + yourValue + " days late before failing.");