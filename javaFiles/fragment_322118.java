public class UnderscorePhysicalStartegy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return context.getIdentifierHelper()
                .toIdentifier(NamingStrategyUtils.classToName(name.getText()));
    }

}