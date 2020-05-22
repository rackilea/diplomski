import com.opensymphony.xwork2.ActionSupport;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.apache.struts2.views.freemarker.FreemarkerManager;

public class DummyAction extends ActionSupport implements ServletContextAware
{
    private static final long serialVersionUID = 1L;
    private ServletContext context;

    public String execute()
    {
        try
        {
            //retrive freemarker config used by struts2 for freemarker results
            FreemarkerManager manager = new FreemarkerManager();
            Configuration cfg = manager.getConfiguration(context);
            Template template = cfg.getTemplate("your-template");

            //your data model
            Object root = new Object();

            //process template
            StringWriter out = new StringWriter();
            template.process(new Object(), out);

            String renderedText= out.toString();

            System.out.println(renderedText);

        } catch (Exception e)
        {
            e.printStackTrace();
        }

        //do work



        return "success?";
    }

    public void setServletContext(ServletContext context)
    {
        this.context = context;
    }
}