Socket s = new Socket(server, port);
TlsProtocolHandler handler = new TlsProtocolHandler(s.getInputStream(),
                                                    s.getOutputStream());
handler.connect(new AlwaysValidVerifyer());
InputStream is = handler.getInputStream();
InputStream os = handler.getOutputStream();
[...]