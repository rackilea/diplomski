import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.xtext.example.mydsl.myDsl.Greeting;
import org.xtext.example.mydsl.myDsl.Model;

import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) throws IOException {
        Injector i = new MyDslStandaloneSetup().createInjectorAndDoEMFRegistration();
        ResourceSet rs = i.getInstance(ResourceSet.class);
        Resource r = rs.getResource(URI.createFileURI("./test.mydsl"), true);
        r.load(null);
        Model m = (Model) r.getContents().get(0);
        for (Greeting g : m.getGreetings()) {
            System.out.println(g.getName());
        }
    }

}