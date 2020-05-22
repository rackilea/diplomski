import org.apache.maven.model.*;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
...
Model model = new Model();
model.setGroupId( "some.group.id" );
...
new MavenXpp3Writer().write( w, model );