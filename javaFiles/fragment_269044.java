include "Ex1.thrift"
    namespace java tut2
    struct Student {
    1:string name,
    2:i32 age,
    3:Ex1.Address add
    }

    service ExampleService {
    list<Student> getListStudent()
    }