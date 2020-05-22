public class LoadResourceServlet extends HttpServlet
{
    private Properties props;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);

        props = new Properties();
        URL url = this.getClass().getResource("/myconfig.properties");
        if (url != null)
        {
            try (InputStream stream = url.openStream())
            {
                props.load(stream);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/plain");

        try (PrintWriter writer = resp.getWriter())
        {
            writer.printf("food = %s%n",props.getProperty("food"));
            writer.printf("fruit.color = %s%n",props.getProperty("fruit.color"));
            writer.printf("fruit.name = %s%n",props.getProperty("fruit.name"));
        }
    }
}