package de.scrum_master.aspect;

import de.scrum_master.app.ReadOnly;

public aspect ReadOnlyGetterAspect {
  declare error :
    set(* *) && withincode(public * get*()) && @withincode(ReadOnly) :
      "Setting members from within a getter is forbidden";

  before() : set(* *) && cflow(execution(@ReadOnly public * get*())) {
    throw new IllegalAccessError("Setting members from within a getter is forbidden");
  }
}