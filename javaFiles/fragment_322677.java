public static void operateMD()
{
    //setTypes();
    double tempPROD=0;
    double tempP1=0;
    double tempP2=0;

    for(int h=0;h<parts.size();h++)
    {
        if(types.get(h).equals("opr")&&((types.get(h-1).equals("num"))&&types.get(h+1).equals("num")))
        {
            if(parts.get(h).equals("*"))
            {
                tempP1=Double.parseDouble(parts.get(h-1));
                tempP2=Double.parseDouble(parts.get(h+1));
                tempPROD=tempP1*tempP2;
                parts.set(h-1, String.valueOf(tempPROD));
                types.set(h-1, "num");
                parts.remove(h);
                parts.remove(h);
                types.remove(h);
                types.remove(h);
            }
            else if(parts.get(h).equals("/"))
            {
                tempP1=Double.parseDouble(parts.get(h-1));
                tempP2=Double.parseDouble(parts.get(h+1));
                tempPROD=tempP1/tempP2;
                parts.set(h-1, String.valueOf(tempPROD));
                types.set(h-1, "num");
                parts.remove(h);
                parts.remove(h);
                types.remove(h);
                types.remove(h);
            }
        //end of if operator conditional
        }
        else if((h!=parts.size()-1)&&((types.get(h).equals("num"))&&types.get(h+1).equals("num")))
        {   
            tempP1=Double.parseDouble(parts.get(h));
            tempP2=Double.parseDouble(parts.get(h+1));
            tempPROD=tempP1*tempP2;
            parts.set(h, String.valueOf(tempPROD));
            parts.remove(h+1);
            types.remove(h+1);
        }
    //end loop to go through each part of arraylist
    }
//end of method
}