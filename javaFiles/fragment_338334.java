public String getFoo() {
        try {
            Field f = this.getClass().getDeclaredField("FOO");
            f.setAccessible(true);
            return (String) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
}