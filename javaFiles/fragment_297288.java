int cases[]=new int[26];
    int[] money = {1,2,5,10,25,50,75,100,200,300,400....};
    Random random = new Random();
    int index = 0;
    firstLoop:
    while(cases[25]==0){
        int randomChosenIndex = random.nextInt(money.length);
        int randomChosenValueFromMoney = money[randomChosenIndex];
        for (int i = 0; i < index; i++) {
            if (cases[i]==randomChosenValueFromMoney) {
                continue firstLoop;
            }
        }
        cases[index++] = randomChosenValueFromMoney;
    }