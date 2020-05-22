@Override
public void setMin(ValueSpecification min_)
{
    min = (min_ instanceof Duration) ? min_ : min;
}

@Override
public void setMax(ValueSpecification max_)
{
     max = (max_ instanceof Duration) ? max_ : max;
}