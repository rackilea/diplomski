public class Location
{
   public void AddEmployee(Employee emp)
   {
      if(!IsFull)
         Employees.Add(emp);
   }

   public void RemoveEmployee(Employee emp)
   {
      Employees.Remove(emp);
      If(Employees.Count < 100)
         IsFull = false;
   }
}