BigInteger big = new BigInteger("515377520732011331036461129765621272702107522001");
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream outputStream = new ObjectOutputStream(baos);
outputStream.writeObject(big);
byte[] rawBytes = baos.toByteArray();

ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(rawBytes));
BigInteger bigReadBack = (BigInteger) inputStream.readObject();

assertThat(big).isEqualTo(bigReadBack);