Node *CutTheList(Node *head)
{
  int sizeList=0;  // Contains the size of the List
  Node *tracker=head; // temporary tracker

  while(tracker!=NULL){ sizeList++; tracker=tracker->next;} // Counts the Size of the List
  tracker=head;

  while(tracker->next!=NULL){tracker=tracker->next;} // Assigns the head to tail.
  tracker->next=head;

  int sizehalf=sizeList/2; //Size of the halved List.
  tracker=head;

  while(--sizehalf){ tracker=tracker->next; } //Update the head
  head=tracker->next; 
  tracker->next=NULL;

  return head;
 }