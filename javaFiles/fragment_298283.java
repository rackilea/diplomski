// If count blob size for a container include snapshots
String prefix = null;
boolean useFlatBlobListing = true;
EnumSet<BlobListingDetails> listingDetails = EnumSet.of(BlobListingDetails.SNAPSHOTS);
BlobRequestOptions options = null;
OperationContext opContext = null;
Iterable<ListBlobItem> blobItems = container.listBlobs(prefix, useFlatBlobListing, listingDetails, options, opContext);