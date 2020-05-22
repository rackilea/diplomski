String connectParams = "//F://eclipse_Luna_64_Development_Workspace//Project JAVA//LIC_AGENCY_TRACKER//DATABASE//LIC_DATA_TRACKER.accdb";
Connection connection = dbcon.DB_Connection(connectParams);
PreparedStatement ps = connection.prepareStatement(
    "update Mode_Of_Payment_Profile set" 
    + " Mode_Of_Payment_Profile_Type=?"
    + ", Mode_Of_Payment_Profile_Description=?"
    + ", Mode_Of_Payment_Profile_Creation_Date=?"
    + " where Mode_Of_Payment_Profile_ID=?");
ps.setString(1, getModeofPaymentType);
ps.setString(2, getModeofPaymentDescription);
ps.setString(3, currdate); 
ps.setString(4, getModeID);