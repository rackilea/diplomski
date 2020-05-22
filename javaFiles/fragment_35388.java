<cfscript>
...
REPLYTO = createObject("java", "javax.mail.internet.InternetAddress").init("testy@testy.com", "Joe Schmoe");
replyToArr = arrayNew(1);
arrayAppend(replyToArr,REPLYTO);
msg.setReplyTo(replyToArr);
...
<cfscript>