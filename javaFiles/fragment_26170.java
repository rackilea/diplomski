@GET
@Produces({MediaType.TEXT_HTML})
public InputStream viewHome()
{
   File f = getFileFromSomewhere();
   return new FileInputStream(f);
}