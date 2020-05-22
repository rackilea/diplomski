HColumn column = columns.get(currentUserId());     
if(null != column)  
{  
     doSomethingWithColumn(column);  // this was the old if block
}   
for(Integer col : columns.keySet())  
{  
    switch(col)  
    {  
       ...  
    }
}