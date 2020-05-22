...
@Override
public List<AssetDTO> getAssets() {
    ...
    Query q = session.createQuery("from Asset");
    List<Asset> assets = new ArrayList<Asset>(q.list());
    List<AssetDTO> assetsDto = new ArrayList<AssetDTO>();
    if (assets != null) {
        for (Asset asset : assets) {
            assetsDto.add(createAssetDTO(asset));
        }
    }
    session.getTransaction().commit();
    return assetsDto;
}

public AssetDTO createAssetDTO(Asset asset) {
    AssetTypeDTO assetTypeDto = new AssetTypeDTO(asset.getAssetType()
                .getId(), asset.getAssetType().getType());
    AssetDTO result = new AssetDTO(asset.getIsin(), asset.getMicCode(),
                asset.getName(), assetTypeDto);
    return result;
}
...