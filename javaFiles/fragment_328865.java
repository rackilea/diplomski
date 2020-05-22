BoneCPConfig config = new BoneCPConfig();
config.setJdbcUrl("jdbc:hsqldb:mem:test_common;shutDown=false");
config.setUsername("sa");
config.setPassword("");
JdbcTemplate dataSource = new BoneCPDataSource(config);
jdbcTemplate = new JdbcTemplate(dataSource);
//If you are using named queries
NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//create necessary tables etc here.
setupDb(jdbcTemplate);

SomeBean anotherBean = new SomeBean();

YourDAO dao = new YourDAOImpl();
dao.setNamedJdbcTemplate(namedParameterJdbcTemplate);
dao.setSomeOtherBean(anotherBean);

//Mimic spring container if you implement InitialzingBean

dao.afterPropertiesSet();