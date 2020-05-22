import org.eclipse.cdt.core.*
import org.eclipse.core.resources.*;

public class MyExErrorParser implements IErrorParser {

    public MyExErrorParser() {
    }

    @Override
    public boolean processLine(String line, ErrorParserManager eoParser) {

        IProject p = ResourcesPlugin.getWorkspace().getRoot()
                                            .getProject("hello_world");

        p.getFile("main.c");

        if(line.contains("my_error_id_str")) {

            int err_lvl = IMarkerGenerator.SEVERITY_ERROR_RESOURCE;

            ProblemMarkerInfo marker = new ProblemMarkerInfo(p , 5, "bad", 
                                                             err_lvl,
                                                             "foo");

            eoParser.addProblemMarker(marker);

            return true;
        }

        return false;
    }
}