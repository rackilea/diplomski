try {
    SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings("/test.txt");
    System.out.println(sharedLinkMetadata.getUrl());
} catch (CreateSharedLinkWithSettingsErrorException ex) {
    System.out.println(ex);
} catch (DbxException ex) {
    System.out.println(ex);
}