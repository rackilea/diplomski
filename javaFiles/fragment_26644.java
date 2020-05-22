NumberFormat formatter = new DecimalFormat("#0.00");  

ArrayList<Integer> numbers = new ArrayList<Integer>();
ArrayList<Integer> counts = new ArrayList<Integer>();

int maxNum = DiceRolling.diceSides;
Scanner sc = new Scanner(System.in);
int rollnum;
int randomValue;

System.out.println("Welcome to the Dice Roll Stats Calculator!");
System.out.println("Enter amount of rolls: ");
rollnum = sc.nextInt();


for (int i  = 0; i < rollnum; i++) {

    randomValue = (1 + (int) (Math.random() * maxNum)) + (1 + (int) (Math.random() * maxNum));

    if(numbers.contains(randomValue)){
        int position = numbers.indexOf(randomValue);
        counts.set(position, counts.get(position)+1);
    }else{
        numbers.add(randomValue);
        counts.add(1);
    }

}

System.out.println("Total\tCount\tPercentage");
System.out.println("-----\t---------\t----------");
for(int i = 0; i<numbers.size(); i++){
    System.out.println(numbers.get(i) +"\t" + counts.get(i) + "\t" + formatter.format(((double)(counts.get(i)*100))/rollnum) + "%";
}