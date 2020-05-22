Iterator<BlobInfo> iterator = null;
iterator = new BlobInfoFactory().queryBlobInfos();
while (iterator.hasNext()) {
    system.out.println(iterator.next().getBlobKey());//You can put condition here whats your file name
    system.out.println(iterator.next().getFilename());
}