Stage0(ArrayList<T> inQ, double inputTime, ArrayList<T> outQ)
{
    super(inQ, inputTime, outQ);   // <======================
    inputQueue = inQ;
    takesTime = inputTime;
    outputQueue = outQ;
}