public void search(list head,  string sname)
{
     boolean found = false;
     int pos = 0;
     list current = head;
   while(!found)           
   {
       //iterate through the list looking for the sname
       //for each node you do not find it 
       //if found change found to true.
       pos++;
       if(!found)
            current = current.next; //iterate to next node
       if(current.sname == head.sname)  //if it made it all the way around without finding the node
           break;  //this prevents an infinite loop.
    }
 if(found) //found = true
    //put output of what you need here.
 if(!found) //found = false
    //output not found message.