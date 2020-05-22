import info.magnolia.dam.api.metadata.MagnoliaAssetMetadata;
// ...
if (asset.supports(MagnoliaAssetMetadata.class)) {
  MagnoliaAssetMetadata metadata = asset.getMetadata(MagnoliaAssetMetadata.class);
  long width = metadata.getWidth();
  long height = metadata.getHeight();
  // do whatever you need with the image dimensions
} else {
  // handle non-image asset
}