@Component
public class A implements InitializingBean {

@Autowired
private B b;

private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "My name is "+name+"; b name is "+b.getName();
}

@Override
public void afterPropertiesSet() throws Exception {
    System.out.println("Creating A");
    System.out.println("B name="+b.getName());
}

}



@Component
public class B implements InitializingBean {

private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "B [name=" + name + "]";
}

@Override
public void afterPropertiesSet() throws Exception {
    System.out.println("Creating b");
}

}



@Component
public class C implements InitializingBean {

@Autowired
private A a;

private String name;

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "My name is "+name+"; a name is "+a.getName();
}

@Override
public void afterPropertiesSet() throws Exception {
    System.out.println("Creating c");
    System.out.println("A name="+a.getName());
}
}