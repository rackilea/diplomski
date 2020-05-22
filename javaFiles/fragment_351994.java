...
public Asset(AssetDTO dto) {
        this.isin = dto.getIsin();
        this.mic_code = dto.getMic_code();
        this.name = dto.getName();
        AssetTypeDTO assetTypeDTO = dto.getAssetType();
        if (assetTypeDTO != null) {
            this.assetType = new AssetType(assetTypeDTO.getId(),
                    assetTypeDTO.getType());
        }
 }
...