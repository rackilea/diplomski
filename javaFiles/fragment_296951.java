int frontIndex = originalString.IndexOf('<jscript>');
int backIndex =  originalString.IndexOf('</jscript>');

String front = originalString.substring(0,frontIndex); 
String back = originalString.substring(backIndex,originalString.length()); 

originalString = front + back;