public static void main(String[] args) {
    DispatchPtr connection = null;
    DispatchPtr results = null;
    try {
        Ole32.CoInitialize();
        connection = new DispatchPtr("ADODB.Connection");
        connection.invoke("Open",
            "Provider=Search.CollatorDSO;" +
            "Extended Properties='Application=Windows';");
        results = (DispatchPtr)connection.invoke("Execute",
            "select System.Title, System.Comment, System.ItemName, System.ItemUrl, System.FileExtension, System.ItemDate, System.MimeType " +
            "from SystemIndex " +
            "where contains('Foo')");
        int count = 0;
        while(!((Boolean)results.get("EOF")).booleanValue()) {
            ++ count;
            DispatchPtr fields = (DispatchPtr)results.get("Fields");
            int numFields = ((Integer)fields.get("Count")).intValue();

            for (int i = 0; i < numFields; ++ i) {
                DispatchPtr item =
                    (DispatchPtr)fields.get("Item", new Integer(i));
                System.out.println(
                    item.get("Name") + ": " + item.get("Value"));
            }
            System.out.println();
            results.invoke("MoveNext");
        }
        System.out.println("\nCount:" + count);
    } catch (COMException e) {
        e.printStackTrace();
    } finally {
        try {
            results.invoke("Close");
        } catch (COMException e) {
            e.printStackTrace();
        }
        try {
            connection.invoke("Close");
        } catch (COMException e) {
            e.printStackTrace();
        }
        try {
            Ole32.CoUninitialize();
        } catch (COMException e) {
            e.printStackTrace();
        }
    }
}