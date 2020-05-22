public class AssetDTO implements Serializable {

    private String isin;
    private String mic_code;
    private String name;
    private AssetTypeDTO assetType;

    public AssetDTO() {
        super();
    }

    public AssetDTO(String isin, String mic_code, String name,
            AssetTypeDTO assetType) {
        super();
        this.isin = isin;
        this.mic_code = mic_code;
        this.name = name;
        this.assetType = assetType;
    }

//incl. Getter + Setter
}