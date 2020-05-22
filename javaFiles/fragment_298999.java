public class MyDao extends JdbcDaoSupport {

    ....

    @Override
    protected void initTemplateConfig() {
        getJdbcTemplate().setFetchSize(200);
    }

}