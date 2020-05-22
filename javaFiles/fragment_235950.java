String message = "BOT.command USER_X    THIS_IS_A_TIME THIS_IS_A_DATE";
String user = null;
String time = null;
String date = null;
// Use toLowerCase - assuming it's case insensitive.
if (message.toLowerCase()
    .startsWith("bot.command")) {
  Scanner st = new Scanner(message);
  if (st.hasNext()) {
    st.next();
  }
  if (st.hasNext()) {
    user = st.next();
  }
  if (st.hasNext()) {
    time = st.next();
  }
  if (st.hasNext()) {
    date = st.next();
  }
}
System.out.printf(
    "User = %s,  Time = %s, Date = %s\n", user,
    time, date);