String task=req.getParameter("task");

switch(task)
{
 case "create":
 System.out.println("task create called");
 break;

 case "update":
 System.out.println("task update called");
 break;

 case "delete":
 System.out.println("task delete called");
 break;
}