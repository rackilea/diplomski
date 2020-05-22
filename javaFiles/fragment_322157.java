static byte array[] = new byte[] { 1, 2, 3, 4, 5, 6 };
    static List<Byte> list = new ArrayList<Byte>();

    public static void main(String[] args) {
        System.out.println("First array: " + Arrays.toString(array));
        new Rotate().arrayshift(2);
        System.out.println("After two shift is: ");
        for (Byte b : list.toArray(new Byte[list.size()]))
            System.out.print(b.byteValue() + ", ");
    }

    public void arrayshift(int count) {
        synchronized (array) {
            Byte[] byteObjects = new Byte[array.length];
            int i = 0;
            for (byte b : array)
                byteObjects[i++] = b;
            list = Arrays.asList(byteObjects);
            Collections.rotate(list, count);
        }
    }