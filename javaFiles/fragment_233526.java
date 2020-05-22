/**
 * Returns empty messages sent between after and before 
 * that contain only identifiers.
 * @param after
 * @param before
 * @param fields fields to be included in response 
 *               (IGNORED see api-explorer)  
 * @return 
 */
public List<Message> getEmptyMessages(Date after, Date before, String fields) {    
    Gmail.Users.Messages.List request = gmailService.users().messages().list("me")
             // or setQ("is:sent after:yyyy/MM/dd before:yyyy/MM/dd")
            .setLabelIds(Arrays.asList("SENT"))
            .setQ("after:" + gmailFormat(after) +" "+ 
                  "before:"+ gmailFormat(before))
            .setMaxResults(MAX_RESULTS)
            .setFields(fields);

    List<Message> list = new LinkedList<>();
    ListMessagesResponse response = null;

    do {
       response = request.execute();
       list.addAll(response.getMessages());
       request.setPageToken(response.getNextPageToken());

    } while (request.getPageToken() != null && request.getPageToken().length() > 0);

    return list;
}

public String gmailFormat(Date d) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    return sdf.format(d);
}