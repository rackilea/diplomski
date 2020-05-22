try
{
        Class.forName(dbObject.getDriver());  
} catch (Exception e)
{
        Logger lgr = Logger.getLogger(PostgreLocationManager.class.getName());
        lgr.log(Level.SEVERE, e.getMessage(), e);
}