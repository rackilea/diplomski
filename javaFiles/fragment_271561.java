Criteria empAttendanceCr=session2.createCriteria(EmployeeSignin.class);
        //EmployeeSigninId empId=new EmployeeSigninId(user.getEmpId().toString());

        Criterion attdDateCondition = Restrictions.conjunction()                    
                .add(Restrictions.eq("id.empId",user.getEmpId().toString()))
                .add(Restrictions.le("id.signinDate", lastDate))
                .add(Restrictions.ge("id.signinDate", startDate));