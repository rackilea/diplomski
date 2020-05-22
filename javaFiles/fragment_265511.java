@Controller
public class SpecialController 
{
    public Model model = null; // set externally

    @RequestMapping(value="your/service/location", method=RequestMethod.GET, produces={"application/x-javascript", "application/json", "application/ld+json"})
    public @ResponseBody String getModelAsJson() {
       // Your existing json response
    }

    @RequestMapping(value="your/service/location", method=RequestMethod.GET, produces={"application/xml", "application/rdf+xml"})
    public @ResponseBody String getModelAsXml() {
       // Note that we added "application/rdf+xml" as one of the supported types
       // for this method. Otherwise, we utilize your existing xml serialization
    }

    @RequestMapping(value="your/service/location", method=RequestMethod.GET, produces={"application/n-triples"})
    public @ResponseBody String getModelAsNTriples() {
       // New method to serialize to n-triple
       try( final ByteArrayOutputStream os = new ByteArrayOutputStream() ){
           model.write(os, "N-TRIPLE");
           return os.toString();
       }
    }

    @RequestMapping(value="your/service/location", method=RequestMethod.GET, produces={"text/turtle"})
    public @ResponseBody String getModelAsTurtle() {
       // New method to serialize to turtle
       try( final ByteArrayOutputStream os = new ByteArrayOutputStream() ){
           model.write(os, "TURTLE");
           return os.toString();
       }
    }

    @RequestMapping(value="your/service/location", method=RequestMethod.GET, produces={"text/n3"})
    public @ResponseBody String getModelAsN3() {
       // New method to serialize to N3
       try( final ByteArrayOutputStream os = new ByteArrayOutputStream() ){
           model.write(os, "N3");
           return os.toString();
       }
    }
}