final List<LogMessage> capturedList = new ArrayList<>();
// This uses a lambda, but you could also do it with an anonymous inner class:
// new Answer<Void>() {
//   @Override public Void answer(InvocationOnMock invocation) { /* ... */ }
// }
when(sender.send(any())).thenAnswer(invocation -> {
  List<LogMessage> argument = (List<LogMessage>) invocation.getArguments()[0];
  capturedList.addAll(argument);
});
bufferedSender.flushBuffer();
assertThat(capturedList).hasSize(5);