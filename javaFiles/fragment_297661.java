internal class AdvancedDateTimeRenderer : IAttributeRenderer
{
    public string ToString(object o)
    {
        return ToString(o, null);
    }

    public string ToString(object o, string formatName)
    {
        if (o == null)
            return null;

        if (string.IsNullOrEmpty(formatName))
            return o.ToString();

        DateTime dt = Convert.ToDateTime(o);

        return string.Format("{0:" + formatName + "}", dt);
    }
}