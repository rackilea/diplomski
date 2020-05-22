if ( !session.containsKey(arrayListID) ) 
{
// Place the number the user entered into the session
session.put(arrayListID, numbersEntered);
} else {
    ArrayList<Integer> list = (ArrayList<Integer>) session.get(arrayListID);
     list.add( 1 /* what you want */);
// Retrieve session data
 }