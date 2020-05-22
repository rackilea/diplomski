public class Person implements Serializable {

    // ...

    private void writeObject(ObjectOutputStream out)
    throws IOException {
        out.defaultWriteObject();

        if (firstImage != null) {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ImageIO.write(firstImage, "png", b);

            out.writeInt(b.size());
            b.writeTo(out);

            System.out.println("First image saved.");
        } else {
            out.writeInt(0);
        }

        if (secondImage != null) {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ImageIO.write(secondImage, "png", b);

            out.writeInt(b.size());
            b.writeTo(out);

            System.out.println("Second image saved.");
        } else {
            out.writeInt(0);
        }
    }

    private void readObject(ObjectInputStream in)
    throws IOException,
           ClassNotFoundException {
        in.defaultReadObject();

        int length = in.readInt();
        if (length > 0) {
            byte[] bytes = new byte[length];
            in.readFully(bytes);
            firstImage = ImageIO.read(new ByteArrayInputStream(bytes));
        }

        length = in.readInt();
        if (length > 0) {
            byte[] bytes = new byte[length];
            in.readFully(bytes);
            secondImage = ImageIO.read(new ByteArrayInputStream(bytes));
        }
    }

}