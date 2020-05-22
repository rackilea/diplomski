public Object getTransferData(DataFlavor df)
        throws UnsupportedFlavorException, IOException
    {
        Object data = transferable.getTransferData(df);
        // If the data is a Serializable object, then create a new instance
        // before returning it. This insulates applications sharing DnD and
        // Clipboard data from each other.
        if (data != null && isLocal && df.isFlavorSerializedObjectType()) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ClassLoaderObjectOutputStream oos =
                new ClassLoaderObjectOutputStream(baos);
            oos.writeObject(data);
            ByteArrayInputStream bais =
                new ByteArrayInputStream(baos.toByteArray());
            try {
                ClassLoaderObjectInputStream ois =
                    new ClassLoaderObjectInputStream(bais,
                                                     oos.getClassLoaderMap());
                data = ois.readObject();
            } catch (ClassNotFoundException cnfe) {

                throw (IOException)new IOException().initCause(cnfe);
            }
        }
        return data;
}