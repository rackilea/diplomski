XMLGregorianCalendar xgc = null;
try
{
    xgc = DatatypeFactory.newInstance().newXMLGregorianCalendar( odt.toString() );
}
catch ( DatatypeConfigurationException e )
{
    e.printStackTrace();
}
System.out.println( "xgc.toString(): " + xgc );