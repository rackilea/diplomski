public String download() throws Exception {

    fileName = getFromDatabaseById(id);

    try
    {
        fileInputStream = new FileInputStream(new File(FILE_FOLDER + filename));
    }
    catch(FileNotFoundException ex)
    {
        logger.error(this.getClass().getSimpleName() + ": File in " + FILE_FOLDER + filename + " cannot be found.");
            return ERROR;
        }

        return DOWNLOAD;
}