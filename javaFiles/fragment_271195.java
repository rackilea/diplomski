public class StageConfig
{
    private static TopMenuButtonsController tmbc = null;
    private static AssisstantController ac = null;

    public static void setTopMenuButtonsController(TopMenuButtonsController tmbc_val)
    {
        StageConfig.tmbc = tmbc_val;
    }
    public static TopMenuButtonsController getTopMenuButtonsController() 
    {
        return StageConfig.tmbc;
    }

    public static void setAssisstantController(AssisstantController ac_val)
    {
        StageConfig.ac = ac_val;
    }
    public static getAssisstantController getController() 
    {
        return StageConfig.ac;
    }

}