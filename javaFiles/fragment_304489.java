package de.scrum_master.stackoverflow.q57210075

import spock.lang.Specification

import java.util.stream.Collectors

class ConditionalMockCreationTest extends Specification {

  class Type0 {}

  class DesiredObject {
    String name

    DesiredObject(String name) {
      this.name = name
    }

    @Override
    String toString() {
      "DesiredObject('$name')"
    }

    boolean equals(o) {
      if (this.is(o)) return true
      if (getClass() != o.class) return false
      DesiredObject that = (DesiredObject) o
      if (name != that.name) return false
      return true
    }

    int hashCode() {
      return (name != null ? name.hashCode() : 0)
    }
  }

  class SomeClassA {
    DesiredObject methodIWantToMockMultipleTimes(Type0 type0, DesiredObject desiredObject) {
      return new DesiredObject("default")
    }
  }

  def someMockedObject = Mock(DesiredObject) {
    toString() >> "some mocked object"
  }
  def someDifferentMockedObject = Mock(DesiredObject) {
    toString() >> "some different mocked object"
  }

  def "original test"() {
    given:
    def listOfObjects = ["A", "B", "C", "D", "E"]
    def someObject = "C"
    SomeClassA classA = Mock() {
      def listOfDesiredObjects = listOfObjects
        .stream()
        .filter({ i -> i != someObject })
        .map({ i -> new DesiredObject(i) })
        .collect(Collectors.toList())

      for (int i = 0; i < listOfDesiredObjects.size(); i++) {
        methodIWantToMockMultipleTimes(_ as Type0, listOfDesiredObjects.get(i) as DesiredObject) >> {
          return someMockedObject
        }
      }

      methodIWantToMockMultipleTimes(_ as Type0, new DesiredObject(someObject)) >> {
        return someDifferentMockedObject
      }
    }

    expect: "normal object yields normal result"
    new SomeClassA().methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "DesiredObject('default')"

    and: "mocked objects yield predefined mock behaviour"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("B")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("C")).toString() == "some different mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("D")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("E")).toString() == "some mocked object"
    // Undefined case -> no stubbed method -> mock returns null
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("XXX")) == null
  }

  def "simplified test with two distinct cases"() {
    given:
    def someObject = new DesiredObject("C")
    SomeClassA classA = Mock() {
      methodIWantToMockMultipleTimes(_, !someObject) >> someMockedObject
      methodIWantToMockMultipleTimes(_, someObject) >> someDifferentMockedObject
    }

    expect: "normal object yields normal result"
    new SomeClassA().methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "DesiredObject('default')"

    and: "mocked objects yield predefined mock behaviour"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("B")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("C")).toString() == "some different mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("D")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("E")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("XXX")).toString() == "some mocked object"
  }

  def "simplified test with special and default case"() {
    given:
    def someObject = new DesiredObject("C")
    SomeClassA classA = Mock() {
      // Attention, this only works if the special case is defined before the default one
      methodIWantToMockMultipleTimes(_, someObject) >> someDifferentMockedObject
      methodIWantToMockMultipleTimes(*_) >> someMockedObject
    }

    expect: "normal object yields normal result"
    new SomeClassA().methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "DesiredObject('default')"

    and: "mocked objects yield predefined mock behaviour"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("B")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("C")).toString() == "some different mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("D")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("E")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("XXX")).toString() == "some mocked object"
  }

  def "simplified test with dynamic stub method"() {
    given:
    def someObject = new DesiredObject("C")
    SomeClassA classA = Mock() {
      methodIWantToMockMultipleTimes(*_) >> { a, b -> b == someObject ? someDifferentMockedObject : someMockedObject }
    }

    expect: "normal object yields normal result"
    new SomeClassA().methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "DesiredObject('default')"

    and: "mocked objects yield predefined mock behaviour"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("A")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("B")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("C")).toString() == "some different mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("D")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("E")).toString() == "some mocked object"
    classA.methodIWantToMockMultipleTimes(new Type0(), new DesiredObject("XXX")).toString() == "some mocked object"
  }
}