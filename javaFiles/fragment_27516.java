PushbackReader pbreader = new PushbackReader (serverinput);
BufferedReader bufferedReader = new BufferedReader(pbreader);
String onelineofinput = bufferedReader.readLine();
if (onelineofinput...) {
    pbreader.unread(onelineofinput.toCharArray());
    pbreader.unread('\n');
    sendpackets(IPaddress, port, new BufferedReader(pbreader), connection);
}