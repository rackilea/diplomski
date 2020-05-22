private List<File> sendRequest(){
    List<File> result = new ArrayList<File>();

    try{
        Files.List request = service.files().list().setQ("trashed = false");

        do{
            try{
                FileList files = request.execute();

                result.addAll(files.getItems());
                request.setPageToken(files.getNextPageToken());
            }
            catch(IOException e){
                System.out.println("An error occurred: " + e);
                request.setPageToken(null);
            }
        }
        while(request.getPageToken() != null
                && request.getPageToken().length() > 0);

    }
    catch(IOException e1){
        e1.printStackTrace();
    }

    for(File file : result){
        Log.d(TAG, "file : " + file.getTitle());
    }
    return result;
}