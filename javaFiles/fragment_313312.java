void saveEnrollment(String filename) throws IOException
{
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
    out.writeObject(allEnrollment);
    out.close();
}