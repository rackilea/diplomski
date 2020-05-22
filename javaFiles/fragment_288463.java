class CustomActivityTask extends Task { // inherit from Activity Task class to add your own fields
    private int someStateOne;
    private String someOtherState;

   (...)
   // getters and setters

}

class CalculationTask {
   private CustomActivityTask avtivityTask; // by updating the state of this task you are updating the state of the task in Activity process engine 
   private RuntimeService activityRuntimeServiece;

   public void run() { // this is your execution functin

      while (true) { 
         // calulate
         activityTask.setSomeStateOne(45)
         activityTask.setSomeOtherState("Task is almost completing..."); 

         (...)

         if (allCompleted) {
             activityRuntimeServiece.complete(avtivityTask.getId(), taskVariables);
             break;

        }

  }
}