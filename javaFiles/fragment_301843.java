private string GetMailBody(string regionCode)
{
    switch(regionCode)
    {
        case "qc":
            //Do some stuff
            break;

        default:
            //If not specified, we assume US, so we do that.
            break;
    }

    return "String we should have edited above";
}