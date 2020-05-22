/**
 * Returns "fully-qualified" message.
 * @param id     identifier of the message to be obtained.
 * @param fields fields to be included in response e.g. "raw,snippet"
 *               (use api-explorer to build this string)
 * @return 
 */
public Message getFullyQualifiedMessage(String id, String fields) {
    return gmailService.users().messages().get("me", id)
            .setFormat("FULL")
            .setFields(fields)
            .execute();
}