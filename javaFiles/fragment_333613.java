public void addEmployees(int a, HashMap<Employee,Hobby> aList)
        {
           Scanner obj = new Scanner(System.in);
           Scanner obj1 = new Scanner(System.in);

           for(int i =0; i<a ; i++)
             {
                Hobby hob = new Hobby();
                Employee emp = new Employee();
                System.out.println("Enter id of employee:");
                int num = obj.nextInt();
                emp.setEmployeeId(num);

                System.out.println("Enter name of employee:");
                String str = obj1. nextLine();
                emp.setName(str);

                hob.enterHobby();
                hMap.put(emp,hob);
              }    
          }