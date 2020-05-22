try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q43843846.class, "test.json") ) {
    final Response response = gson.fromJson(jsonReader, Response.class);
    for ( final ScriptElement element : response.script ) {
        if ( element instanceof ScriptClickable ) {
            final ScriptClickable clickable = (ScriptClickable) element;
            System.out.println(clickable.redirect);
        } else if ( element instanceof ScriptInput ) {
            final ScriptInput input = (ScriptInput) element;
            System.out.println(input.content);
        } else {
            throw new AssertionError(element);
        }
    }
}