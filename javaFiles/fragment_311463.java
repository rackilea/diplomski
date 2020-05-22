@Bean(name = "InterfaceA")
public InterfaceA interfaceA() {
    return new ClassC();
}

@Bean(name = "InterfaceB")
public InterfaceB interfaceB() {
    return new ClassC();
}