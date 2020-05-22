package com.example.gson;

import java.util.List;

public class ConfigData {

    private Boolean enabled;
    private ContentMetadataPartial contentMetadataPartial;
    private List<Integer> simulatedChanges = null;
    private List<SimulatedUpdateMetadatum> simulatedUpdateMetadata = null;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public ContentMetadataPartial getContentMetadataPartial() {
        return contentMetadataPartial;
    }

    public void setContentMetadataPartial(ContentMetadataPartial contentMetadataPartial) {
        this.contentMetadataPartial = contentMetadataPartial;
    }

    public List<Integer> getSimulatedChanges() {
        return simulatedChanges;
    }

    public void setSimulatedChanges(List<Integer> simulatedChanges) {
        this.simulatedChanges = simulatedChanges;
    }

    public List<SimulatedUpdateMetadatum> getSimulatedUpdateMetadata() {
        return simulatedUpdateMetadata;
    }

    public void setSimulatedUpdateMetadata(List<SimulatedUpdateMetadatum> simulatedUpdateMetadata) {
        this.simulatedUpdateMetadata = simulatedUpdateMetadata;
    }

    @Override
    public String toString() {
        return "ConfigData [enabled=" + enabled + ", contentMetadataPartial=" + contentMetadataPartial
                + ", simulatedChanges=" + simulatedChanges + ", simulatedUpdateMetadata=" + simulatedUpdateMetadata
                + "]";
    }

}