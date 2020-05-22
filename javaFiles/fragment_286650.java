int j=0;
while(j < msg.getRecipients(Message.RecipientType.CC).length)
{
  System.out.println(j);
  cc = cc.concat(msg.getRecipients(Message.RecipientType.CC)[j].toString());
  cc = cc.concat(",");
  j++;
}