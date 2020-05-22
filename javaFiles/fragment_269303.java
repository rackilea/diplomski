public class TabInformation 
{
public String tag;
private Class<?> clss;
private Bundle args;
private Fragment fragment;

TabInformation(String tag, Class<?> clazz, Bundle args) 
{
    this.tag = tag;
    this.clss = clazz;
    this.args = args;
}