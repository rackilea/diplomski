import org.apache.jena.riot.RDFDataMgr
import org.apache.jena.riot.Lang  
...

    Model model = null;
    try(OutputStream out = new FileOutputStream("filename.rdf")) {
        RDFDataMgr.write(out, model, Lang.RDFXML);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }