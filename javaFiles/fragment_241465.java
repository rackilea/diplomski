Node temp = head;
int randomX = (int) (Math.random() * 10 + 1);

//simply go until the randomX
while(randomX-- > 0 && temp.getNext() != null)
    temp = temp.getNext();

//remove the Nth node from the list
temp.getPrevious().setNext(temp.getNext());

if(temp.getNext() != null)
    temp.getNext().setPrevious(temp.getPrevious());

//set it to point to the head
temp.setNext(head);
temp.setPrevious(null);

//now set the Head to the Nth node we found
head = temp;