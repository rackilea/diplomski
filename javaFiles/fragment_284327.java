HttpServletRequest request = (HttpServletRequest) req;
String header = request.getHeader("Authorization");
byte[] base64Token = header.substring(10).getBytes("UTF-8");
byte[] spnegoHeader = Base64.decode(base64Token);

SpnegoInitToken spnegoToken = new SpnegoInitToken(spnegoHeader);