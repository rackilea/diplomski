ListIterator<Task> iterator = this.taskCollection.listIterator();
boolean marker = false;

if(taskCollection.isEmpty())
    this.taskCollection.add(t);
else {
   while (iterator.hasNext()) {
      if(iterator.next().isOverlapped(t) == false)
         marker = true;
   }
}

if (marker == true)
    taskCollection.add(t);