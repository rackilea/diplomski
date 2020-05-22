private String SEPARATOR = ",";

    public String getEncodedValues()
    {
        final StringBuffer returnValue = new StringBuffer();

        returnValue.append(field1);
        returnValue.append(SEPARATOR);
        returnValue.append(field2);
        returnValue.append(SEPARATOR);
        returnValue.append(field3);

        return returnValue.toString();
    }