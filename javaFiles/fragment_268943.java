// qualifier can be omitted, then it will be "UseClass1" by default
@Service("beanName1") 
public class UseClass1 implements SomeInterface { } 

// qualifier can be omitted, then it will be "UseClass2" by default
@Service("beanName2")
public class UseClass2 implements SomeInterface { }