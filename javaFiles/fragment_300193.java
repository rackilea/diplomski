public int compareTo(Object obj) 
{
    double b= ((Employee)obj).getSalary();
    double a= this.salary;
    return Double.compare(a, b); 
}