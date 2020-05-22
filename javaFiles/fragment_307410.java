public Employee getEmployee(){
    return this.emp1.clone();  // this solution assumes that Employee
                               // is safely cloneable, which requires some
                               // care on your part.  An alternative is
                               // to define a copy constructor in the
                               // Employee class and: return new Employee(emp1);
}