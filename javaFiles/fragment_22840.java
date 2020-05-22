DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd/MM/yyyy HH:mm:ss" ) ;
 …   
if(Info.get("TIME")!=null)
{
    try {
        Date date = format.parse( Info.get("TIME") ) ;
        Instant instant = date.toInstant() ;
        OffsetDateTime odt = instant.atOffset( ZoneOffset.UTC ) ;
        String output = odt.format( f ) ;
        message.TimeHistory.add(date);
    }
    catch (Exception e){

    }
}