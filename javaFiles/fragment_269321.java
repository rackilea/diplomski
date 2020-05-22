private Consumer<Item> processingAction = this::processItem;

public void setProcessingAction(Consumer<Item> action) {
   this.processingAction = action;
}

public void doSomething(Collection<Item> batch)  { 
   batch.stream()      
   .filter(item -> item.group_id == 1)      
   .forEach(processingAction);
}