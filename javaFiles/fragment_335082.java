if (max == 0)
{
    resultSet = statement.executeQuery("SELECT max(TripNumber) FROM BikeTripRecords");
    resultSet.next();
    min = resultSet.getInt(1);
}