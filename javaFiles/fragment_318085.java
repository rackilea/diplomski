// No need to provide the scope, since singleton is the default one
@Component
public MySingletonBean {

    private final String key;

    // Yes, the constructor is private, but spring will see it anyway
    private MySingletonBean() {
        key = generateAKey();
    }

    private String getKey() {
        return this.key;
    }
}