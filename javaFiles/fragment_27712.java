// myCloudBlobClient is a CloudBlobClient
CloudBlobContainer myCloudBlobContainer = myCloudBlobClient.getContainerReference("containername")
// I expected to get all files thanks to the next row
Iterable<ListBlobItem> blobs = myCloudBlobContainer.listBlobs();
// only directories here, another for needed to scan files
for (ListBlobItem blob : blobs) {
    if (blob instanceof CloudBlobDirectory) {
        CloudBlobDirectory directory = (CloudBlobDirectory)blob;
        //next is in try/catch
        Iterable<ListBlobItem> fileBlobs = directory.listBlobs();
        for (ListBlobItem fileBlob : fileBlobs) {
            if (fileBlob instanceof CloudBlob) {
            CloudBlob cloudBlob = (CloudBlob) fileBlob;
            //make nice things with every found file
            }
        }
    } // else: may be we found a cloudBlob in root?
}