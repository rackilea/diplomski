@Get
public Representation getImage() {

    ...
    byte[] data = ...

    ObjectRepresentation<byte[]> or=new ObjectRepresentation<byte[]>(data, MediaType.IMAGE_PNG) {
        @Override
        public void write(OutputStream os) throws IOException {
            super.write(os);
            os.write(this.getObject());
        }
    };

    return or; 
}