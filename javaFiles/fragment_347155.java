package samp.rest.ws.controller;

import java.util.List;
import samp.rest.ws.ThingDB;
import samp.rest.ws.vo.Thing;

import javax.ws.rs.*;

@Path("/thing")
public class ThingController {

    @GET
    @Path(value = "/things")
    @Produces("application/json")
    public List<Thing> getThings() {
        return ThingDB.getThings();
    }

    @GET
    @Path(value = "/thing/{id}")
    @Produces("application/json")
    public Thing getThingById(@PathParam("id") int id) {
        return ThingDB.getThing(id);
    }

    @GET
    @Path(value = "/thingy/{id}")
    public String getThingy(@PathParam("id") int id) {
        return ThingDB.getThing(id).toString();
    }

    @PUT
    @Path(value = "/addthing")
    @Produces("application/json")
    public void addThing(Thing thing) {
        ThingDB.addThing(thing);

        List<Thing> lt = ThingDB.getThings();
        for (Thing t : lt) {
            System.out.println(" Post add: " + t.toString());
        }
    }
}