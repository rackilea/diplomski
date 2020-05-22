package de.scrum_master.aspect;

import de.scrum_master.app.IVehicle;
import de.scrum_master.app.Authenticated;
import de.scrum_master.app.RacingApp;

public aspect VehicleActionInterceptor {
  before(Authenticated authenticated) :
    execution(* IVehicle+.*(..)) && @annotation(authenticated) &&
    cflow(call(* IVehicle+.*(..)) && within(RacingApp))
  {
    System.out.println(thisJoinPoint + " -> " + authenticated);
  }
}