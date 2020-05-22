NumberFormat percentDisplayFormat = NumberFormat.getPercentInstance();
NumberFormat editFormat = NumberFormat.getNumberInstance();

percentDisplayFormat.setMinimumFractionDigits(2);

NumberFormatter percentEditFormatter = new NumberFormatter(editFormat);

// This was the new change that I have made
NumberFormatter percentDisplayFormatter = new NumberFormatter(percentDisplayFormat)
{
    @Override
    public String valueToString(Object o) throws ParseException
    {
        Double number = null;
        if (o != null)
        {
            number = Double.valueOf(o.toString());
            number /= 100;
        }
        // In super class, it multiplies the number by 100. So as we are dividing the number by 100 here. In super level it will become the same value that we have given        
        return super.valueToString(number);
    }
};

JFormattedTextField jftfPercentage = new JFormattedTextField(new DefaultFormatterFactory(percentDisplayFormatter, percentDisplayFormatter, percentEditFormatter));

jftfPercentage.setBounds(113, 95, 236, 21);
jftfPercentage.setName("JftfPercentage");