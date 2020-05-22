for (int i = 0; i < myCollection.size(); i++) 
{     
    List myList = myCollection.get(i);
    for (int j = 0; j < myList.size(); j++) 
    {
        System.out.println("myList.get(j) -- "+myList.get(j).toString());      
    }
}