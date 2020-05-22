package de.scrum_master.app;

import java.io.Serializable;

@Document(collection = "address")
public class Address extends Identity<Long> implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer zipCode;
  private String country;

  public Address(Long id, Integer zipCode, String country) {
    super(id);
    this.zipCode = zipCode;
    this.country = country;
  }

  @Override
  public String toString() {
    return "Address [id=" + getId() + ", zipCode=" + zipCode + ", country=" + country + "]";
  }
}