// excludes list of recipients
@JsonView(View.Summary.class)
@GetMapping("/")
public List<Message> getAllMessages() {
    return messageService.getAll();
}

// includes list of recipients
@JsonView(View.SummaryWithRecipients.class)
@GetMapping("/with-recipients")
public List<Message> getAllMessagesWithRecipients() {
    return messageService.getAll();
}