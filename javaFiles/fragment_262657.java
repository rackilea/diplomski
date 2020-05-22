public void create_tables(String maquina, String usuario, String senha) {
    System.out.println("create_tables");
    create_properties(maquina, usuario, senha);

    Configuration config = new Configuration();
    Properties props = new Properties();
    FileInputStream fos;
    try {
        fos = new FileInputStream( "database.properties" );
        props.load(fos);
        fos.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    config.setProperties(props);

    config.addAnnotatedClass(com.horariolivre.entity.Atributo.class);
    config.addAnnotatedClass(com.horariolivre.entity.ConfigHorarioLivre.class);
    config.addAnnotatedClass(com.horariolivre.entity.Evento.class);
    config.addAnnotatedClass(com.horariolivre.entity.HorarioLivre.class);
    config.addAnnotatedClass(com.horariolivre.entity.Key.class);
    config.addAnnotatedClass(com.horariolivre.entity.Tipo.class);
    config.addAnnotatedClass(com.horariolivre.entity.Value.class);
    config.addAnnotatedClass(com.horariolivre.entity.Autorizacao.class);
    config.addAnnotatedClass(com.horariolivre.entity.Usuario.class);

    try {
        String url = props.getProperty("jdbc.url");
        Connection conn = DriverManager.getConnection(url,usuario,senha);
        SchemaExport schema = new SchemaExport(config, conn);
        schema.create(true, true);
    } catch (SQLException e) {
        e.printStackTrace();
    }

    insert_default_values();
}