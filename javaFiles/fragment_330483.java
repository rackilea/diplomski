private boolean isLineVariableDeclaration(String line)
{
    this.hasAccessMode(line)
    // call other functions too ..
}

private bool hasAccessMode(String line)
{
    String access = line.Split(" ")[0].toLowerCase();

    // Check if AccessMode list has "access"
    // return true if it exists
}

private bool hasOtherQualifier(String line)
{
    String qualifier = line.Split(" ")[1].toLowerCase();

    // Check if OtherQualifier list has "qualifier"
    // return true if it exists
}

private bool hasDataType(String line)
{
    String dataType = line.Split(" ")[2].toLowerCase();

    // Check if DataType list has "dataType"
    // return true if it exists
}

private bool hasEndMarker(String line)
{
    String endMarker = line.Split(" ")[3].toLowerCase();

    // Statement looks like
    // private static int someVar;
    if(endMarker.Equals(";"))
    {
        // since this is line end
       // return true;
    }
    // Statement looks like
    // private static int someVar, someOtherVar;
    else if(endMarker.Equals(","))
    {
        // this means there are more variables so such type
        // do more to collect them
    }
}