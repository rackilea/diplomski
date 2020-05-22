int count = 0;
for (int i = 0; i < winners.length; i++){
    if (winners[i].equals(name)){
        count ++;
        System.out.println(years[i]);
    }
}
System.out.println(name + " has won it" + count + "times");