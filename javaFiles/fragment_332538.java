boolean remove(Word w)
{
    WordNode wm = new WordNode(w);

    if (list == null) return false; //can't delete on an empty list
    else
    {
        WordNode aux = list;
        WordNode prev = aux;

        while(aux != null)
        {
            if (wm.word.getName().compareTo(aux.word.getName()) == 0 ) //if the word to delete is found
            { 
                if (aux.next == null) //to erase the last element
                {
                    prev.next = null;
                    // Takes care of the case of a one-item list
                    aux = null;
                }
                else
                {
                    aux.word.setName(aux.next.word.getName()); //set current node's name to equal next node's

                    WordNode temp = aux.next.next;
                    aux.next = null; //to erase current node
                    aux.next = temp; //re-refer
                }                        
                return true;
            }
            else {
                prev = aux;
                aux = aux.next;
        }

        return false; //reachable if word is not found
    }
}