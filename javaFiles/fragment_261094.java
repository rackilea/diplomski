while (true) {
  Message<?> receive = channel.receive(10000);
  if (receive == null) {
      break;
  }
  variable("tt", receive.toString());
  echo("${tt}");
}