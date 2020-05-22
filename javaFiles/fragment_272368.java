List<ITask> tasks = new WritableList(new ArrayList<ITask>(), ITask.class);

// Let's say tableViewerTasks is your TableViewer's name

DragSource sourceTasks = new DragSource(tblTasks, DND.DROP_MOVE);
sourceTasks.setTransfer(new Transfer[]{TaskTransfer.INSTANCE});
sourceTasks.addDragListener(new MyDragSourceListener(tableViewerTasks, true, ITask.class));

DropTarget targetTasks = new DropTarget(tblTasks, DND.DROP_MOVE);
targetTasks.setTransfer(new Transfer[]{TaskTransfer.INSTANCE});
targetTasks.addDropListener(new MyDropAdapter<ITask>(tableViewerTasks, ITask.class, tasks));