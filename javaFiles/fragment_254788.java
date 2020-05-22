private void writeFile(String fileName, String content) {

    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream(fileName), "utf-8")))
    {
        writer.write((String) content);
    } catch (UnsupportedEncodingException e)
    {
        e.printStackTrace();
    } catch (FileNotFoundException e)
    {
        e.printStackTrace();
    } catch (IOException e)
    {
        e.printStackTrace();
    }
}