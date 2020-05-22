public static class MyProvider extends Provider {

    @Override
    protected void clearKey(String name) {
        // clearing logic
    }

    @Override
    protected String getValue(String name) {
        // read logic
    }

    @Override
    protected void setValue(String name, String value) {
        // store logic
    }
}

StateManager.get().setProvider(new MyProvider());