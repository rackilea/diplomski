BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
    String data;
    int fieldNumber;
    boolean isInteger;

    fieldNumber = 0;
    isInteger = false;
    while(isInteger == false)
    {
        System.out.print("Enter a field between 1 and " + maxValue + "(< zero to quit): ");
        data = br.readLine();
        NumberFormatException nfe = new NumberFormatException();
        try
        {
            fieldNumber = Integer.parseInt(data);
            if(fieldNumber > maxValue)
                throw nfe;
            isInteger = true;

        }
        catch(NumberFormatException nfe2)
        {
            System.out.println("You did not enter a valid integer");
        }
    }
        return fieldNumber - 1;