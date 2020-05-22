for(int i=0;i<3;i++) {
        emp[i] = new EmployeeDetail();
        System.out.println("Enter the employee "+(i+1)+" name");
        emp[i].EmpName=scn.nextLine();
        System.out.println("Enter the employee "+(i+1)+" number");
        emp[i].EmpNumber=Integer.parseInt(scn.nextLine());
        System.out.println("Enter the employee "+(i+1)+" Mobile number");
        emp[i].MobNumber=Long.parseLong(scn.nextLine());
        System.out.println("Enter the employee "+(i+1)+" Salary");
        emp[i].Salary=Float.parseFloat(scn.nextLine());
    }