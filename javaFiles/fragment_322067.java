@ActiveProfiles("test")
@SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)
 @SqlGroup({
    @Sql(statements = "DROP SCHEMA PUBLIC CASCADE"),
    @Sql(scripts = "classpath:yourGeneratedSQL.sql"),
})