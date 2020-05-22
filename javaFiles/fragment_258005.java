public class SubConfigurable implements Configurable<SubConfigurable> {

    @Override
    public SubConfigurable setConfig(SubConfiguration config) {
        this.config = config;
        return this;
    }
}