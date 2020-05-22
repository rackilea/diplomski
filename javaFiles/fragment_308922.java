// ...
else if (getOperand().startsWith("0"))
    {
        String op = getOperand();
        return Integer.parseInt(op, 8)*sign;
    }
// ...