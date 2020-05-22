Map<Long, List<Comment>> commentMap = new HashMap<>();
for (Message singleMessage : messages) {
  /* retrieve messageComments for this singleMessage here */
  commentMap.put(singleMessage.getId(), messageComments);
}
model.addAttribute("commentMap", commentMap);