private void send() {
   Context context = new Context();
   context.setVariable("name", "hello");
   String result = springTemplateEngine.process("hello", context);
   simpMessagingTemplate.convertAndSend(destination, result);
}