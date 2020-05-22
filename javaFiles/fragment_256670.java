@Path("/employee")
    public class EmployeesResource {

        static Logger log = LoggerFactory.getLogger(EmployeesResource.class);

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public List<Employees> index(@BeanParam Employees paramBean) {
            EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
            List<Employees> result = dao.read();
            System.out.println("Get all employees: size = " + result.size());
            return result;
        }

        @GET
        @Path("{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Employees show(@PathParam("id") Integer id) {
            EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
            System.out.println("Get employees -> id = " + id);
            return dao.read(id);
        }

        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public Integer create(Employees obj) {
            EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
            return dao.create(obj);
        }

        @PUT
        @Path("{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public void update(Employees obj, @PathParam("id") String id) {
            EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("employeesDao");
            dao.update(obj);
        }

        @DELETE
        @Path("{id}")
        public void destroy(@PathParam("id") Integer id) throws Exception {
            EmployeesDao dao = (EmployeesDao) SpringApplicationContext.getBean("EmployeesDao");
            dao.delete(id);
        }
    }