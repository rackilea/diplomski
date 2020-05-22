@Path("/dynamic-classes")
public class DynamicRestResource {
    private static final Map<String, Class<?>> CLASS_NAME_MAP = Collections.unmodifiableMap(new HashMap<String, Class<?>>(){
        private static final long serialVersionUID = 1L;

    {
            put(MyClass1.class.getSimpleName().toLowerCase(), MyClass1.class);
            put(MyClass2.class.getSimpleName().toLowerCase(), MyClass2.class);
                        //... put here your other classes.
            }}
    );
  private Class<?> getMappedClass(String mappedPath) {
    return CLASS_NAME_MAP.get(mappedPath);
  }

  @GET
  @Path("/{className}")
  public Collection<?> getAll(@PathParam("className") String className) {
    //do some checks that there is such a path
    return dao.getAll(this.getMappedClass(className));
  }

  @DELETE
  @Path("/{className}/{entityId}")
  public Collection<?> deleteEntity(@PathParam("className") String className, @PathParam("entityId") Long entityId) {
    //do some checks that there is such a path
    return dao.delete(this.getMappedClass(className), entityId);
  }
}