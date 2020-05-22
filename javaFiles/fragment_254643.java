private static void printAll() {
    for (int index = 0; index < toDoItems.size(); index++)
      System.out.println(toDoItems.get(index));
  }

// Extra bracket is removed from here.

  public static void deleteToDoItem() {
    System.out.print("Enter index of item to delete: ");
    int delete = k.nextInt();
    toDoItems.remove(i);
  }
} // put it here.