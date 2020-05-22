int qualityPoints = 0;
    int sumOfHours = 0; 
    double GPA = 0;

    DecimalFormat df = new DecimalFormat("0.00");
    GPA = Double.parseDouble(df.format (((double)qualityPoints) /(double)(sumOfHours)));