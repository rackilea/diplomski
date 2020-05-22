class AndGate
{
    NMOS t1, t2;
    public AndGate()
    {
        t1 = new NMOS(new BinaryDigit(0));
        t2 = new NMOS(new BinaryDigit(0));
    }

    public BinaryDigit map(BinaryDigit input1, BinaryDigit input2)
    {
        t1.setInput(input1);
        t2.setInput(input2);

        return new BinaryDigit(((t1.isOpen() && t2.isOpen()) ? (1) : (0));
    }
}