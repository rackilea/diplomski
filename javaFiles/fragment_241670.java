public void actionPerformed(ActionEvent ae)
{
    if (ae.equals(save))
    {
        String sqlInsert1 = "INSERT INTO Drivers (IDNumber, FirstName, LastName) VALUES " + Id +"," + FirstName+"," + Surname;
        String sqlInsert2 = "INSERT INTO Offences(IDNumber, SpeedLimit, DriverSpeed, SeatBelt, DrunkenDriving, DriversLicense) VALUES" + Id + SpeedLimit + DriversSpeed + Seatbelt + DrunkenDriving + License;
        String sqlInsert3 = "INSERT INTO DriverPoints(IDNumber, Points) VALUES" + Id + Points;

        database.writeToDB(sqlInsert1,sqlInsert2,sqlInsert3);
    }