if(!resultSet.next())
{
    result.append("No record for ");
    result.append(this.student);
    result.append(".");
}
else // <-- failurehere
{