for(Category current: Planner.getDetails().keySet())  
{  
    CategoryTime = 0  
    Display Category Header
    Activity Time = 0
    for(Planner currentPlanner : planner.getDetails().get(current))  
    {  
          currentPlanner.getActivity();  
          Activity Time += currentPlanner.getTime();
    }  
}