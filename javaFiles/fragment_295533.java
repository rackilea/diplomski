public class ClsMessage 
{
    public String username = "";
    public String password = "";
    public String request = "";

    public List<Parameters> parameters = new ArrayList<Parameters>();

    public static class Parameters {
        public String name = "";
        public String value = "";
    }
}

for(ClsMessage.Parameters param : clsMessage.parameters)
{
    ....
}