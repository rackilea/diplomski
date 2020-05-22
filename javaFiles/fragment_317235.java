if (file.getParentFile().exists || file.getParentFile().mkdirs()){
        try
        {
            file.createNewFile();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
} else {
  /** could not create directory and|or all|some nonexistent parent directories **/
}