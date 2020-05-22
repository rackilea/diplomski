public static void main(String[] args) {
    Dispatch connection = null;
    Dispatch results = null;

    try {
        connection = new Dispatch("ADODB.Connection");
        Dispatch.call(connection, "Open",
            "Provider=Search.CollatorDSO;Extended Properties='Application=Windows';");
        results = Dispatch.call(connection, "Execute",
            "select System.Title, System.Comment, System.ItemName, System.ItemUrl, System.FileExtension, System.ItemDate, System.MimeType " +
            "from SystemIndex " +
            "where contains('Foo')").toDispatch();
        int count = 0;
        while(!Dispatch.get(results, "EOF").getBoolean()) {
            ++ count;
            Dispatch fields = Dispatch.get(results, "Fields").toDispatch();
            int numFields = Dispatch.get(fields, "Count").getInt();

            for (int i = 0; i < numFields; ++ i) {
                Dispatch item =
                    Dispatch.call(fields, "Item", new Integer(i)).
                    toDispatch();
                System.out.println(
                    Dispatch.get(item, "Name") + ": " +
                    Dispatch.get(item, "Value"));
            }
            System.out.println();
            Dispatch.call(results, "MoveNext");
        }
    } finally {
        try {
            Dispatch.call(results, "Close");
        } catch (JacobException e) {
            e.printStackTrace();
        }
        try {
            Dispatch.call(connection, "Close");
        } catch (JacobException e) {
            e.printStackTrace();
        }
    }
}