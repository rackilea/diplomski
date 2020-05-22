package org.netbeans.rest.application.config;

import com.s63c.verplaatsingdata.Registratiekast;
import com.s63c.verplaatsingdata.Verplaatsing;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Koenkk
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(Verplaatsing.class);
        resources.add(Registratiekast.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.s63c.verplaatsingsysteem.rest.VerplaastingREST.class);
    }

}