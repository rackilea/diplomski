Query query =  entityManager.createQuery("select t from AssignTaskEmployee t WHERE 
t.assignTaskEmployeePk.employeeId = :employeeId and t.assignTaskEmployeePk.taskId = :taskId")

query.setParameter("employeeId", 1);
query.setParameter("taskId",1);

query.getSingleResult()  //As expected to have only one record.