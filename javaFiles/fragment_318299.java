public ServiceResult execute(final Http.MultipartFormData request)
{
    final String DIRECTORY = "C:\\SAVE_DIRECTORY\\SUB_FOLDER\\uploads";

        List<Http.MultipartFormData.FilePart> targetFiles = request.getFiles();

        for (int i = 0; i < targetFiles.size(); i++)
        {
            File file = targetFiles.get(i).getFile();

            String fileName = targetFiles.get(i).getFilename();

            file.renameTo(new File(DIRECTORY, fileName));
        }

        return new ServiceResult(Json.toJson(targetFiles));
    }