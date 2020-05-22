class List {
    static Object taskList[] = new Object[5];
    boolean extraSpace = false;

    public static void main (String[] args) throws java.lang.Exception {
        List list = new List();

        list.add(new Object());
        list.add(new Object());

        for(int i = 0; i < taskList.length; i++) {
            System.out.println(taskList[i]);
        }
    }

    // Constructor
    public List() {
        for(int i = 0; i < taskList.length; i++) {
            if(taskList[i] == null) {
                extraSpace = true;
                break;
            }
        }
    }

    public void add(Object task) {
        // check for any null indexes, if found fill them
        if(extraSpace) {
            boolean added = false;
            for(int i = 0; i < taskList.length; i++) {
                if(taskList[i] == null) {
                    if(!added) {
                        taskList[i] = task;
                        added = true;
                    } else {
                        extraSpace = true;
                        break;
                    }
                }
                extraSpace = false;
            }
        } else {
           // if no null indexes then create new array with +1 length, then
           // copy old array to new adding new task in the process.
           Object[] newTaskList = new Object[taskList.length + 1];
           for(int i = 0; i < taskList.length; i++) {
               newTaskList[i] = taskList[i];
           }
           newTaskList[newTaskList.length - 1] = task;
           taskList = newTaskList;
        }
    }
}