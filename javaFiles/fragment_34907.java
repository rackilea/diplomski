if (request.getSpeedInfo() == null
||
request.getSpeedInfo().getBandwidth() == null
||
request.getSpeedInfo().getBandwidth().isEmpty())
{
    // request is invalid
}
else
    // request is valid ...