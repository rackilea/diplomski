void testSomething() {
    def emp = new Employee(first:"Aaron", last:"Saunders")
    emp.save()

    emp =  Employee.get(1)

    emp.addToProjects(new Project(name:"Project 3"))
    emp.addToProjects(new Project(name:"Project 1"))
    emp.addToProjects(new Project(name:"Project 2"))

    emp.save()

    println Employee.get(1)

    println Employee.get(1).projects.first()
}