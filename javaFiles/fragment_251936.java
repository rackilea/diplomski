byte[] bytemsg = new byte[message.remaining()];
System.out.println("client message length = " + bytemsg.length);

// !!! Copy the content of 'message' to 'bytemsg' here !!!

String a2sview = Arrays.toString(bytemsg);
System.out.println("client message a2sview: " + a2sview);