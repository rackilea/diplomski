private void outputHeader(Writer out, String name, String username, String woSeclevel)
  throws IOException
{
    String hdr = String.format("Employee Name: %s  Username: %s  "
            + "WO Security Level %s%n",
            name, 
            username,
            woSeclevel);

    out.write(hdr);
}

private void ouputLine(Writer out, String menu, String tab, String desc)
    throws IOException
{
    String line = String.format("Menu: %s > %s > %s%n",
                                menu,
                                tab,
                                desc);
    out.write(line);
}