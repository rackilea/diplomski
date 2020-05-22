import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.example.DomainmodelStandaloneSetup;
import org.eclipse.xtext.example.domainmodel.Greeting;
import org.eclipse.xtext.example.domainmodel.Model;

import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) throws IOException {
        Injector i = new DomainmodelStandaloneSetup().createInjectorAndDoEMFRegistration();
        ResourceSet rs = i.getInstance(ResourceSet.class);
        Resource r = rs.getResource(URI.createFileURI("./src/mydsl.dmodel"), true);
        r.load(null);
        Model m = (Model) r.getContents().get(0);
        for (Greeting g : m.getGreetings()) {
            System.out.println(g.getNamee());
        }
    }

}