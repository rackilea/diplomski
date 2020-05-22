In class Space

public String toStringLong(){
if (_portal!= null)
{
// comment this Portal p= new Portal();
_portal.toStringLong();
String Longcombined=_name + ": " + _description+" with a "+_portal.toStringLong();
return Longcombined;
}
else
{
String Long=_name + ": " + _description;
return Long;
}
}


Class Portal ->

public String toStringLong()
{
String combined=toString() + " to " + _destination.getDescription() ;
return combined;
}