@Controller
public class MyController {

    @RequestMapping(value = "/Giris.jsp")
    public void home(final Writer writer) 
            throws IOException  {
            return 'Giris';
    }    
}