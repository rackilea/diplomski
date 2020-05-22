public class Oracle12cExtendedDialect extends Oracle12cDialect {

public Oracle12cExtendedDialect() {
    super();
    registerFunction(
            "regexp_like", new SQLFunctionTemplate(StandardBasicTypes.BOOLEAN,
                    "(case when (regexp_like(?1, ?2)) then 1 else 0 end)")
    );
}
}