public void insertar(String tabla, List<Binding> bindings) 
{
    String alta = "insert into " + tabla + " values(";
    for(int i = 0; i < datos.size(); i++) {
        alta = alta + "?,";
    }
    alta = alta.substring(0, alta.length() - 1) + ")";
    System.out.println(alta);
    try 
    {
        PreparedStatement insertar = con.prepareStatement(alta);
        for(Binding binding : bindings)
        {
            binding.bind(insertar);
        }
        insertar.execute();
    } 
    catch (SQLException ex) 
    {
    }
}