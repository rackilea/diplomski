ByteArrayOutputStream bOut = new ByteArrayOutputStream();
ObjectOutputStream out = new ObjectOutputStream(bOut);
out.writeObject(new Jedi("Obiwan"));
out.close();

byte[] payload = bOut.toByteArray();

ByteArrayInputStream bIn = new ByteArrayInputStream(payload);
ObjectInputStream in = new ObjectInputStream(bIn);
Jedi jedi = (Jedi) in.readObject();
in.close();

System.out.println(jedi);