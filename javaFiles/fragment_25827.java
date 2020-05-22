package de.scrum_master.stackoverflow

import org.junit.Rule
import org.togglz.junit.TogglzRule
import org.togglz.testing.TestFeatureManager
import spock.lang.Specification

import static PocToggle.USE_MY_FEATURE

class PocToggleTest extends Specification {
  @Rule
  TogglzRule toggleRule = TogglzRule.allEnabled(PocToggle.class)

  def "Feature is active when enabled"() {
    when:
    toggleRule.enable(USE_MY_FEATURE)

    then:
    USE_MY_FEATURE.isActive()
  }

  def "Feature is inactive when disabled"() {
    when:
    toggleRule.disable(USE_MY_FEATURE)

    then:
    !USE_MY_FEATURE.isActive()
  }

  def "Feature defaults to active upon feature manager error"() {
    setup: "inject error-throwing feature manager into Togglz rule"
    def featureManagerSpy = Spy(TestFeatureManager, constructorArgs: [PocToggle]) {
      isActive(_) >> { throw new IllegalStateException() }
    }

    when: "feature is disabled and feature manager throws an error"
    toggleRule.disable(USE_MY_FEATURE)
    USE_MY_FEATURE.featureManager = featureManagerSpy

    then: "feature is reported to be active by default"
    USE_MY_FEATURE.isActive()

    cleanup: "reset Togglz rule feature manager"
    USE_MY_FEATURE.featureManager = null
  }
}