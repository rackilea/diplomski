package com.example.gson;

public class SimulatedUpdateMetadatum {

    private CustomTags customTags;
    private String assetName;
    private Integer duration;
    private Integer encodedRate;

    public CustomTags getCustomTags() {
        return customTags;
    }

    public void setCustomTags(CustomTags customTags) {
        this.customTags = customTags;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getEncodedRate() {
        return encodedRate;
    }

    public void setEncodedRate(Integer encodedRate) {
        this.encodedRate = encodedRate;
    }

}