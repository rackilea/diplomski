public List<Map<String, Object>> demoReadEmail2(String folderName) throws MessagingException,IOException {
    List<Map<String, Object>> myList = new ArrayList<>();
    for (Message message : getUnseenMailsByCurrentDate(folderName)) {
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("From",message.getFrom()[0]);
        stringObjectHashMap.put("To",Arrays.toString(message.getRecipients(Message.RecipientType.TO)));
        stringObjectHashMap.put("CC",Arrays.toString(message.getRecipients(Message.RecipientType.CC)));
        stringObjectHashMap.put("BCC",Arrays.toString(message.getRecipients(Message.RecipientType.BCC)));
        stringObjectHashMap.put("Subject",message.getSubject());
        myList.add(stringObjectHashMap);
    }
   return myList;
}