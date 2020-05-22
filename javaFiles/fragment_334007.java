//This String object will live as long as "context" will live
String userText = context.getRequestParameter( "addedText"); //"addedText" goes to a String Pool
if ( someCondition)
{
//This String object will live as long as "userText" variable is accessible
   userText = StringEscapeUtils.unescapeHtml4( userText ) );
}
else
{
//This String object will live as long as "userText" variable is accessible
  userText =  userText.replace( charsequence1, charsequence2 );
}