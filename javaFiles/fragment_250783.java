// recursively download a folder from Dropbox to the local file system
public static void downloadFolder(String path, String destination) throws IOException {
    new File(destination).mkdirs();
    try {
        for (DbxEntry child : client.getMetadataWithChildren(path).children) {
            if (child instanceof DbxEntry.Folder) {
                // recurse
                downloadFolder(path + "/" + child.name, destination + "/" + child.name);
            } else if (child instanceof DbxEntry.File) {
                // download an individual file
                OutputStream outputStream = new FileOutputStream(
                    destination + "/" + child.name);
                try {
                    DbxEntry.File downloadedFile = client.getFile(
                        path + "/" + child.name, null, outputStream);
                } finally {
                    outputStream.close();
                }
            }
        }
    } catch (DbxException e) {
        System.out.println(e.getMessage());
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}