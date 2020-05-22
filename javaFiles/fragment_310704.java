@RequestMethod("/blammy")
public String blammy(
    final ModelMap model,
    final WebRequest webRequest)
{
    String something = webRequest.getParameter("something");

    if ("hoot".equals(something))
    {
        ... process a hoot request
    }
    else if ("bark".equals(something))
    {
        ... process a bark request
    }
}