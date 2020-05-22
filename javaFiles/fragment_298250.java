private void writeToSDCard() {


try
        {
            File file = new File(Environment.getExternalStorageDirectory(),
                    "filename");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("Hello World");
            writer.close();
        } catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
}