@Path("drivers")
public interface IDriver {

    @Get
    public String GetDriverByID(int id);

}