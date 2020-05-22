int maxMonthIndex = 0;

for(int i = 1; i < set2014.length; i++){
    if(set2014[i] > set2014[maxMonthIndex]){
        maxMonthIndex = i;
    }
}

System.out.println("Largest figure is " + set2014[maxMonthIndex]);
System.out.println("In month " + months[maxMonthIndex]);