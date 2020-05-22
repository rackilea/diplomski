public class UpperCaseNamingStrategy extends PhysicalNamingStrategyStandardImpl {

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
        return context.getIdentifierHelper().toIdentifier(
            StringUtils.upperCase(name.getText(), Locale.ENGLISH));
    }

}