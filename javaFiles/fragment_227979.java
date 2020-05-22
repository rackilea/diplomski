public double mode(double[] data)
{
    if(data.length==1)
        return data[0];
    double temp;
    double [] fr = new double [data.length];  //store frequency
    int visited = -1;  

    for(int i = 0; i < data.length; i++)
    {           
        int count = 1;  
        for(int j = i+1; j < data.length; j++)
        {  
            if(data[i] == data[j])
            {  
                count++;   
                fr[j] = visited;  
            }  
        }  
        if(fr[i] != visited)  
            fr[i] = count;  
    }  


    for (int i = 0; i < fr.length; i++)   // sort array in decreasing order
    {
        for (int j = i + 1; j < fr.length; j++) 
        {
            if (fr[i] < fr[j]) 
            {
                temp = data[i];
                data[i] = data[j];
                data[j] = temp;

                temp = fr[i];
                fr[i] = fr[j];
                fr[j] = temp;
            }
        }
    }

    if(fr[0] == fr[1])
        return Double.NaN;
    else
        return data[0];

}