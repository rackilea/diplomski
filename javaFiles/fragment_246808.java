class SalaryComparator
  implements Comparator
{
  public int compare(Object paramObject1, Object paramObject2)
  {
    Emp localEmp1 = (Emp)paramObject1;
    Emp localEmp2 = (Emp)paramObject2;
    int salaryDiff = localEmp1.salary - localEmp2.salary;
    if (salaryDiff != 0) {
      return salaryDiff;
    } else {
      if (localEmp1.job == null) {
        if (localEmp2.job == null) {
          return 0;
        } else {
          return 1;
        }
      } else {
        if (localEmp2.job == null) {
          return -1;
        } else {
          return localEmp1.job.compareTo(localEmp2.job);
        }
      }
    }
  }
}