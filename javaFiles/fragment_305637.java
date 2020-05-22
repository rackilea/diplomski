public void run() {
    for (Job job = jobStack.pop(); job != null; job = jobStack.pop()) {
        try
        {
            System.out.println ("Worker " + id +" started job  ");
            job.doJob();   
            System.out.println("Worker " + id + " started job " + job.getId());
        }
        catch (Exception e)
        {            
            System.out.println ("Exception is caught");
        }
     }
   }
  }