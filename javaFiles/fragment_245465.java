public AbstractAccount CreateAccount(String[] data)
{
    if(data == null || data.length != 7){

        // received data doesn't contain all the expected fields...
        // maybe check the data before sending it to this method?

        return null;
    }


    String firstname = data[0];
    String lastname = data[1];
    String id = data[2];
    String phonenum = data[3];
    String username = data[4];
    String password = data[5];
    String accounttype = data[6];

    if (accounttype.equals("Admin"))
        return new AdminModel(firstname, lastname, id, phonenum, username, password);
    else if (accounttype.equals("CourseCoordinator"))
        return new CourseCoordinatorModel(firstname, lastname, id, phonenum, username, password);
    else if (accounttype.equals("Approver"))
        return new ApproverModel(firstname, lastname, id, phonenum, username, password);
    else if (accounttype.equals("CasualStaff"))
        return new CasualStaffModel(firstname, lastname, id, phonenum, username, password);
    else
        return null;
}