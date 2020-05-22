public class ServletFilter extends IniShiroFilter
{
    @Override
    protected Ini loadIniFromConfig() {
        return new MyIni();
    }

    @Override
    protected Ini loadIniFromPath() {
        return this.loadIniFromConfig();
    }
}