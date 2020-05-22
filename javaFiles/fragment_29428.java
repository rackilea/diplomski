@ExceptionHandler(TaskNotFoundException.class)
@ResponseBody
@ResponseStatus(value = HttpStatus.NOT_FOUND)
private Message handleMessage(TaskNotFoundException e) {
    Message message = new Message();
    message.setTimestamp(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
    message.setError("Not Found");
    message.setStatus(404);
    message.setException("com.TaskNotFoundException");
    message.setMessage("Unknown Task");
    return message;
}