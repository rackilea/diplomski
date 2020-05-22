public static void main(String[] args) {
    try {
        List<Prescription> d = new ArrayList<Prescription>();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("C:\\temp\\Prescription.dat")));
        d.add(new Prescription());
        oos.writeObject(d);
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}