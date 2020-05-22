public void addNewTask(String task)
{
    boolean flag = false;

    for(int i = 0;i<TaskList.size();i++)
    {
        if(task.equals(TaskList.get(i).getTask()))
        {
            Toast.makeText(context,"Task already exists!",Toast.LENGTH_SHORT).show();
            flag = true;
            break;
        }
    }
    if(!flag)
    {
        TaskModel newTaskObj = new TaskModel();
        newTaskObj.setTask(task);
        newTaskObj.setDone(false);
        newTaskObj.setCourseName(course);

        TaskList.add(newTaskObj);
        notifyDataSetChanged();

        realm.beginTransaction();
        realm.insert(newTaskObj);
        realm.commitTransaction();
    } }