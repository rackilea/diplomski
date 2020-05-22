package org.acme.foo.impl;

class PersonEx extends Person {
  @Override
  public void setName(String name) {
    if(name.length()<3) throw new IllegalArgumentException();
    super.setName(name);
  }
}

@XmlRegistry
class ObjectFactoryEx extends ObjectFactory {
  @Override
  Person createPerson() {
    return new PersonEx();
  }
}