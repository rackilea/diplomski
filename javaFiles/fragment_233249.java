ToDoList.addComponent(ToDoTable);
Button link = new Button("Click Me!");
ToDoList.addComponent(link);
link.addClickListener(ClickListener()
  {
      onClick()
      {
          Window mywindow = new Window("My Dialog");
          mywindow.setPositionX(200);
          mywindow.setPositionY(100);
          mainwindow.addWindow(mywindow);
      }

  });