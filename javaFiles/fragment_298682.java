double min = Double.POSITIVE_INFINITY;
double max = Double.NEGATIVE_INFINITY;
double avg = 0.0;
for(int i = 0; i < vals.size(); i++)
{
    avg += vals.get(i);
    if(vals.get(i) < min)
        min = vals.get(i);
    if(vals.get(i) > max)
        max = vals.get(i);
}
avg /= vals.size();