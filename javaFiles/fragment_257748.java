boolean needAttachment = false;
switch (os) 
{
    case ASSIGN_TO_ADMIN:
        // other stuff
        needAttachment = true;
        break;
    // other cases, where attachment is not sent
}
if (needAttachment)
{
    sendEmailWithAttachment(toList, ccList);
} else {
    sendEmailWithoutAttachment(toList, ccList);
}