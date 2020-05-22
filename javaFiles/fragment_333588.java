@Component(immediate = true)
@Service(value=javax.servlet.Servlet.class)
@Properties(value = {
@Property(name="sling.servlet.methods", value={ "POST" }),
//
@Property(name="sling.servlet.paths", value={"/someaction/dothis"})
})
public class ServletEvaluation extends SlingAllMethodsServlet {
...
}