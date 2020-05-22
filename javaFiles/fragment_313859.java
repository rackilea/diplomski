import de.tudresden.sumo.cmd.Vehicle;
 import it.polito.appeal.traci.SumoTraciConnection;

 SumoTraciConnection conn = new SumoTraciConnection(sumo_bin, config_file);
 conn.runServer();

 //load routes and initialize the simulation
 conn.do_timestep();

 double angle = (double) conn.do_job_get(Vehicle.getAngle("v0"));