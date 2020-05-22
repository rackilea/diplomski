class FlagsRepresenter extends Representer {
    public FlagsRepresenter() {
        this.representers.put(Flags.class, new RepresentFlags());
    }

    private class RepresentFlags implements Represent {
        public Node representData(Object data) {
            // going the hacky, painful way of accessing a private field here.
            // YMMV.
            try {
                final Field f = data.getClass().getDeclaredField("_flags");
                f.setAccessible(true);
                final Map<String, Boolean> inner =
                        (Map<String, Boolean>) f.get(data);
                return representMapping(Tag.MAP, inner, null);
            } catch (final Exception ignored) {
                // will not occur as long as field _flags exists and has the
                // expected type.
                return null;
            }

        }
    }
}