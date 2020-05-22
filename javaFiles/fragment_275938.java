//create FileOutputStream object
   FileOutputStream fos = new FileOutputStream(strFilePath);

/*
 * To create DataOutputStream object from FileOutputStream use,
 * DataOutputStream(OutputStream os) constructor.
 */

   DataOutputStream dos = new DataOutputStream(fos);

   int i = 100;

/*
 * To write an int value to a file, use
 * void writeInt(int i) method of Java DataOutputStream class.
 *
 * This method writes specified int to output stream as 4 bytes value.
 */

   dos.writeInt(i);

/*
 * To close DataOutputStream use,
 * void close() method.
 *
 */

   dos.close();