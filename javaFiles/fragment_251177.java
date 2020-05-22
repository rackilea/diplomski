public static Function<String, Employee> populateEmp(){
        Employee ee = new  Employee();
        System.out.print("I am executed");
        return t->{
            System.out.print("I am not");
            return null;
        };
    }