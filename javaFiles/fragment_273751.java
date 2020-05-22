class Alpha {

    @SuppressWarnings("unchecked")
    <T extends Alpha> T test() {
        return (T) this;
    }
}