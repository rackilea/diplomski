public class xmlFileExten
{
    public static void main(final String[] args)
    {

        final List<String> extensionList = getExtensionList("1.xml");
        System.out.print(extensionList); // return [.bak, .tmp, .frm, .opt, .met, .i]
    }

    private static List<String> getExtensionList(final String fileName)
    {
        final List<String> results = new ArrayList<>();
        try
        {
            final File file = new File(fileName);

            final DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder();

            final Document doc = dBuilder.parse(file);

            if (doc.hasChildNodes())
            {

                results.addAll(getExtensionList(doc.getChildNodes()));

            }

        }
        catch (final Exception e)
        {
            System.out.println(e.getMessage());
        }
        return results;
    }

    private static List<String> getExtensionList(final NodeList nodeList)
    {
        final List<String> results = new ArrayList<>();
        for (int count = 0; count < nodeList.getLength(); count++)
        {

            final Node   tempNode = nodeList.item(count);
            final String value    = tempNode.getNodeValue();
            if (tempNode.getNodeType() == Node.TEXT_NODE && value != null && !value.trim().isEmpty())
            {
                results.add(value.trim());
            }
            results.addAll(getExtensionList(tempNode.getChildNodes()));
        }

        return results;
    }
}