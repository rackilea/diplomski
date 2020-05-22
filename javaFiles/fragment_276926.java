int total2 = total;
//Loop
for(i = 0;i <= numOfDays;i++){
    System.out.print("(" + i + ") " + total+ "   ");
    total -= 5;
    if (total<=20){
        System.out.print("\nBecause mark drops below 20, mark stays as 20. final mark="+ finalMark);
        break;
    }
}
System.out.print("\nThis work can be up to " + Math.floor((total2 – 40) / 5)+ " days late before failing.");