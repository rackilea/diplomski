total = 0;
amount = 0;
while(true) {
    amount = TC.getNum();
    if (amount < 0)
        break;
    total = total + amount;
}