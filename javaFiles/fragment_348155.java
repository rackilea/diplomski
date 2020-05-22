BigInteger big = new BigInteger("515377520732011331036461129765621272702107522001");
OutputStream fos = new FileOutputStream("big.ser");
ObjectOutputStream outputStream = new ObjectOutputStream(fos);
outputStream.writeObject(big);
fos.close();

ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("big.ser"));
BigInteger bigReadBack = (BigInteger) inputStream.readObject();

assertThat(big).isEqualTo(bigReadBack);