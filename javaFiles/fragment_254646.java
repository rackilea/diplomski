public static void printAll() {
  Collections.sort(toDoItems, new Comparator<ToDoItem>() {
    @Override
    public int compare(ToDoItem o1, ToDoItem o2) {
      return o1.getPriority().getValue() - o2.getPriority().getValue();
    }
  });
  //System.out.print(toDoItems.size() + ". ");
  for (int index = 0; index < toDoItems.size(); index++)
    System.out.println(index + ". " + toDoItems.get(index));
}