package my.taglibs;

import java.io.Writer;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class ParamTag extends ComponentTagSupport {

    private String map;
    private static final long serialVersionUID = 2522878390854066408L;
    Log log = LogFactory.getLog(ParamTag.class);

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Param(stack);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Param param = (Param) component;
        param.setMap(map);
    }

    public void setMap(String map) {
        this.map = map;
    }

    public class Param extends Component {

        private String map; 

        public Param(ValueStack stack) {
            super(stack);
        }

        @Override
        public boolean end(Writer writer, String body) {
            Component component = findAncestor(Component.class);
            if (this.map == null) {       
                log.warn("Attribute map is mandatory.");
                return super.end(writer, "");
            }
            Object o = findValue(this.map); //find map in vs
            if(o == null) {
                log.warn("map not found in ValueStack");
                return super.end(writer, "");
            }
            if(!(o instanceof Map)) {
                log.warn("Error in JSP. Attribute map must evaluate to java.util.Map. Found type: " + o.getClass().getName());
                return super.end(writer, "");
            }

            component.addAllParameters((Map) o);
            return super.end(writer, "");
        }

        public void setMap(String map) {
            this.map = map;
        }
    }
}