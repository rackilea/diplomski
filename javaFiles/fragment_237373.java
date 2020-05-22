public double distance(ArrayList<Double> a1, ArrayList<Double> a2)
{
    if(a1.size() != a2.size())
        return Double.MAX_VALUE;

    double sum = 0.0;
    for(int i=0; i<a1.size(); i++)
        sum += Math.abs(a1.get(i)-a2.get(i));

    return sum;
}