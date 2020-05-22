@Results({
    @Result(name = "success", location = "/WEB-INF/content/index.jsp")
})
public class IndexController extends RestActionSupport implements Preparable{
    private String page;
    private String pageTitle;

    @Override
    public void prepare() throws Exception {
        page = "home";
        pageTitle= "My Home Page";
    }
    ...
}