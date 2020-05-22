package de.scrum_master.app;

import java.io.Serializable;

public class Identity<ID extends Serializable> {
  @Id private ID id;

  public Identity(ID id) { this.id = id; }
  public ID getId() { return id; }
  public void setId(ID id) { this.id = id; }
  @Override public String toString() { return "Identity [id=" + id + "]"; }
}