package de.scrum_master.stackoverflow

import org.junit.Rule
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.modules.junit4.PowerMockRunnerDelegate
import org.spockframework.runtime.Sputnik
import org.togglz.core.context.FeatureContext
import org.togglz.junit.TogglzRule
import org.togglz.testing.TestFeatureManager
import spock.lang.Specification

import static PocToggle.USE_MY_FEATURE
import static org.powermock.api.mockito.PowerMockito.mockStatic
import static org.powermock.api.mockito.PowerMockito.when

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(Sputnik.class)
@PrepareForTest([FeatureContext.class])
class PocToggleTest extends Specification {
  @Rule
  TogglzRule toggleRule = TogglzRule.allEnabled(PocToggle.class)

  // ...

  def "Feature defaults to active upon feature manager error (power-mocked)"() {
    setup: "inject error-throwing feature manager into Togglz rule"
    def featureManagerSpy = Spy(TestFeatureManager, constructorArgs: [PocToggle]) {
      isActive(_) >> { throw new IllegalStateException() }
    }
    mockStatic(FeatureContext)
    when(FeatureContext.getFeatureManager()).thenReturn(featureManagerSpy)

    when: "feature is disabled and feature manager throws an error"
    toggleRule.disable(USE_MY_FEATURE)

    then: "feature is reported to be active by default"
    USE_MY_FEATURE.isActive()
  }
}