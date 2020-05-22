c = (StreamConnection) Connector.open(
         myServer, Connector.READ_WRITE);
Reader r = new InputStreamReader(c.openInputStream(), "UTF-8");
StringBuffer sb = new StringBuffer();
int ch;
while((ch = r.read()) != -1)
    sb.append((char)ch + "->" + ch + "\n");