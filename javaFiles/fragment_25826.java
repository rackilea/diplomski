package de.scrum_master.stackoverflow;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.context.FeatureContext;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.metadata.FeatureMetaData;
import org.togglz.core.repository.FeatureState;

public enum PocToggle implements Feature {
  @EnabledByDefault
  USE_MY_FEATURE;

  private FeatureManager customFeatureManager;

  void setFeatureManager(FeatureManager featureManager) {
    this.customFeatureManager = featureManager;
  }

  public boolean isActive() {
    FeatureManager featureManager = customFeatureManager != null
      ? customFeatureManager
      : FeatureContext.getFeatureManager();

    try {
      return featureManager.isActive(this);
    } catch (RuntimeException ignored) {
      System.err.println(String.format("Failed to retrieve feature '%s' state", this.name()));
      FeatureMetaData metaData = featureManager.getMetaData(this);
      FeatureState featureState = metaData.getDefaultFeatureState();
      return featureState.isEnabled();
    }
  }
}