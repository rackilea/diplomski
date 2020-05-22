public static void main(String[] args) {
    try {
        ScriptEngineManager factory = new ScriptEngineManager();
        // create a JavaScript engine
        ScriptEngine engine = factory.getEngineByName("JavaScript");
        // evaluate JavaScript code from String
        String expression
                = "name == \"John\" && age < 30 && address.city == \"Frankfurt\"";
        Person person = new Person("John", 25, new Address("Frankfurt"));
        System.out.println(engine.eval(expression, new BeanBindings(person)));
    } catch (ScriptException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static class Person {
    String name;
    int age;
    Address address;

    Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public Address getAddress() {
        return address;
    }
}
public static class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
}

private static class BeanBindings implements Bindings {
    private final Object bean;

    public BeanBindings(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object put(String name, Object value) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> toMerge) {
    }

    @Override
    public boolean containsKey(Object key) {
        Method getter = getter((String)key);
        return getter != null;
    }

    @Override
    public Object get(Object key) {
        Method getter = getter((String)key);
        try {
            return getter == null ? null : getter.invoke(bean);
        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<String> keySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<Object> values() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private Method getter(String propName) {
        if (propName == null || propName.length() == 0) {
            throw new IllegalArgumentException("empty property name");
        }
        try {
            String sfx = Character.toUpperCase(propName.charAt(0))
                    + propName.substring(1);
            return bean.getClass().getMethod(
                    "get" + sfx, new Class[0]);
        } catch (NoSuchMethodException ex) {
            return null;
        } catch (SecurityException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}