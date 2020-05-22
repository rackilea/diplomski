// manually convert you'r data to JSON string, and send as text
@RequestMapping(value={GET_MESSAGES_URL}, 
    method=RequestMethod.GET, produces=MediaType.TEXT_PLAIN) throws ...
@ResponseBody String getMessages()
{
    // getting List<MesssageViewItem>
    List<MessageViewItem> messages=...;
    return mapper.writeValueAsString(messages);
}