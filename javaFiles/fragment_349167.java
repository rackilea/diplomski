public double getNewUnitConversion()
{
    //convert from english standard
    if (input.equals("in"))
    {
        if (output.equals("ft"))
        {
            ft = in * inch_feet;
            System.out.println(ft + "ft");
            return ft;
        }
        else if (output.equals("mi"))
        {
            mi = in * inch_miles;
            System.out.println(mi + "mi");
            return mi;
        }
        else if (output.equals("mm"))
        {
            mm = in * inch_millimeters;
            System.out.println(mm + "mm");
            return mm;
        }
        else if (output.equals("cm"))
        {
            cm = in * inch_centimeters;
            System.out.println(cm + "cm");
            return cm;
        }
        else if (output.equals("m"))
        {
            m = in * inch_meters;
            System.out.println(m + "m");
            return m;
        }
        else if (output.equals("km"))
        {
            km = in * inch_kilometers;
            System.out.println(km + "km");
            return km;
        }  
        else if (output.equals("in"))
        {
            System.out.println(in + "in");
            return in;
        }  
        else 
        {
            System.out.println("Error: Must enter linear unit of measure in, ft, mi, mm, cm, m, or km");
            return 0;
        }
    }
    //convert from metric
    else
    {
        if (output.equals("cm"))
        {
            cm = mm * millimeter_centimeters;
            System.out.println(cm + "cm");
            return cm;
        }
        else if (output.equals("m"))
        {
            m = mm * millimeter_meters;
            System.out.println(m + "m");
            return m;
        }
        else if (output.equals("km"))
        {
            km = mm * millimeter_kilometers;
            System.out.println(km + "km");
            return km;
        }
        else if (output.equals("in"))
        {
            in = mm * millimeters_inch;
            System.out.println(in + "in");
            return in;
        }
        else if (output.equals("ft"))
        {
            ft = mm * millimeters_feet;
            System.out.println(ft + "ft");
            return ft
        }
        else if (output.equals("mi"))
        {
            mi = mm * millimeters_miles;
            System.out.println(mi + "mi");
            return mi;
        }
        else if (output.equals("mm"))
        {
            System.out.println(mm + "mm");
            return mm;
        }
        else 
        {
            System.out.println("Error: Must enter linear unit of measure in, ft, mi, mm, cm, m, or km");
            return 0;
            }
        }
    }
}