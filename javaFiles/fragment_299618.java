public String getPhoneNumber ( String phoneNumber )
{
     StringBuffer sb = new StringBuffer();

     sb.append( phoneNumber.substring(0, 3) );
     sb.append( phoneNumber.substring( 4 ) );

    return sb.toString();
}