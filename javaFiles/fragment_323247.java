@Autowired
ServletContext servletContext;

@Bean
public aBean someBean() {
     File someFolderDirUrl = new File( servletContext.getRealPath("/WEB-INF/") );
     ....
}