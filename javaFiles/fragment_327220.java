public class Manager extends Employee {
    // accessing protected member of itself
    public void foo1() {   
        System.out.println("" + this.hireDay);  // OK
    }

    // access protected member of instance of same type
    public void foo2(Manager manager) {  
        System.out.println("" + manager.hireDay);  // OK
    }

    // access protected member of instance of super-class
    public void foo3(Employee employee) {
        System.out.println("" + employee.hireDay);  // NOT ALLOWED!
    }
}