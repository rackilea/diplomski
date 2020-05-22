private SqlMapClientTemplate sqlMapClientTemplate;

public void setSqlMapClient(SqlMapClient sqlMapClient)
{
    this.sqlMapClientTemplate = new SqlMapClientTemplate(sqlMapClient);
}