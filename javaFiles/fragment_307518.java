package de.scrum_master.stackoverflow.q60167623

import spock.lang.Specification

class ChildTest extends Specification {
  static final PrintStream originalSysOut = System.out
  PrintStream mockSysOut = Mock()

  def setup() {
    System.out = mockSysOut
  }

  def cleanup() {
    System.out = originalSysOut
  }

  def test() {
    given:
    def child = new Child()

    when:
    child.method()

    then:
    1 * mockSysOut.println({ it.contains("parent") })
    child.name == "John Doe"
  }
}