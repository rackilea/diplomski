final byte number1 = 89;
final byte number2 = 45;
final byte number3 = 75;
final ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();
final DataOutputStream o = new DataOutputStream(byteOutput);
o.writeByte(number1);
o.writeByte(number2);
o.writeByte(number3);
//for other types you can do:
//        o.writeBoolean();
//        o.writeUTF();
//etc.
final byte[] bytes = byteOutput.toByteArray();
o.close();
//now you can send this array.
// to read the data sent simply take your input stream:
// or alternatively: val inputStream = DataInputStream(mBluetoothSocket!!.inputStream)
final ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
final DataInputStream inputStream = new DataInputStream(byteInputStream);
System.out.println(inputStream.readByte()); //prints number 1 aka 89
System.out.println(inputStream.readByte()); //prints number 2 aka 45
System.out.println(inputStream.readByte()); //prints number 3 aka 75