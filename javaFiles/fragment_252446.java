@Autowired
    private ServletContext servletContext;

    private String a;
    public void setA(String a) {
       servletContext.setAttribute("a",a);
    }