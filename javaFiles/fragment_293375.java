ScrollBar sc = new ScrollBar()
{
    @Override
    public void adjustValue(double position)
    {
        // figure out the "value" associated with the specified position

        double posValue = ((getMax() - getMin()) * Utils.clamp(0, position, 1)) + getMin();

        double newValue;

        if (Double.compare(posValue, getValue()) != 0)
        {
            if (posValue > getValue())
            {
                newValue = getValue() + getBlockIncrement();
            }
            else
            {
                newValue = getValue() - getBlockIncrement();
            }

            setValue( Utils.clamp(getMin(), newValue, getMax()) );
        }
    }
};