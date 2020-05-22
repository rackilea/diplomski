public class Oracle10gExtendedDialect extends Oracle10gDialect {

    public Oracle10gExtendedDialect() {
        super();
        registerFunction(
          "regexp_like", new SQLFunctionTemplate(StandardBasicTypes.BOOLEAN,
          "(case when (regexp_like(?1, ?2, ?3)) then 1 else 0 end)")
        );
    }

}