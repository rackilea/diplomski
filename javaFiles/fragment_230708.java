public int Nov2()
{
    char[] ops = new char[] {'+', '-', '*', '/'};
    int i = rand.nextInt(4-0) + 0;
    char op1 = ops[i];

    int novnum1 = rand.nextInt(101-1) + 1;

    int novnum2 = rand.nextInt(101-1) + 1;

    int result = 0;

    switch(op1) {
        case '+': result = novnum1 + novnum2; break;
        case '-': result = novnum1 - novnum2; break;
        case '*': result = novnum1 * novnum2; break;
        case '/': result = novnum1 / novnum2; break;
    }

    String nov2Exp = novnum1 + " " + op1 + " " + novnum2 + " = ";

    setContentView(R.layout.gameview);

    TextView display = (TextView) findViewById(R.id.exp);

    display.setText(nov2Exp);

    return result;
}