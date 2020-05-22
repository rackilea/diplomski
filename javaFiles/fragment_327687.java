public ArrayList getTaskDao(Contributor contributor, Task task, String status) 
{  
    getConnection();

    Query query = session.createQuery("Select t.taskId,t.task from Task t where status='"+status+"'");
    ArrayList tasklist = (ArrayList) query.list();
    logger.info(tasklist.size());
    List list = new ArrayList();
    list.add(tasklist.get(0));
    return (ArrayList) list;
}