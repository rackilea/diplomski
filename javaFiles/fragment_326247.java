@Action(value="/books/{author}/{year}")
public class Books extends ActionSupport {
    private String  author; 
    private Integer year;
    /* ...GETTERS AND SETTERS HERE... */

    public String execute(){            
        /* ...LOAD DATA HERE... */
        if (noDataFound)
            return NONE;
        return SUCCESS
    }
}