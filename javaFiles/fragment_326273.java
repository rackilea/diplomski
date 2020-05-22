String keysFromString = "One|Two|Three";      
Stack<String> s = new Stack<String>();
List <String> stringList = new ArrayList<String>(); 

if (keysFromString .contains("|")) 
{
    String[] keys = keysFromString .split("|");
    //grab all but the last string in keys and add it to stack (s)
    for (int i = 0; i < keys.length - 1; i++) 
    {
         s.add(keys[i])
    }
    //add the last string from the split method to the stringList
    stringList.add(keys[keys.length - 1]);
 }