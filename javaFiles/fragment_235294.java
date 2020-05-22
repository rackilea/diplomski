package de.scrum_master.aspect;

import de.scrum_master.app.IVehicle;
import de.scrum_master.app.Authenticated;

public aspect VehicleActionInterceptor {
  before(Authenticated authenticated) : execution(* IVehicle+.*(..)) && @annotation(authenticated) {
    System.out.println(thisJoinPoint + " -> " + authenticated);
  }
}