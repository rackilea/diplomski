private void SenderFile(File file)
{
    try
    {
        FileInputStream fis = new FileInputStream(file);
        OutputStream os = socket.getOutputStream();

        DataOutputStream wrapper = new DataOutputStream(os);
        wrapper.writeLong(file.length());
        IoUtil.copy(fis, wrapper);
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }
}