EmailMessage emailMessage;
while (resultSet.next()) {
       emailMessage = new EmailMessage();
       emailMessage.setCategory(resultSet.getString("category"));
       emailMessage.setSubject(resultSet.getString("subject"));
       emailMessage.setBody(resultSet.getString("body"));
       emailMessageList.add(emailMessage);
}