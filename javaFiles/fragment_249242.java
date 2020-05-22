for (int i = 0; i < salary.length; i++)
{
   if (salary[i] != null)
   {
      salarySum += salary[i].Total();
   }
}

for (int e = 0; e < expenses.length; e++)
{
   if (expenses[e] != null)
   {
      expenseSum += expenses[e].Total();
   }
}