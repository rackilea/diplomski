public class BarFactory
    {   
       public static Bar createBar(Foo foo)
       {
          Bar bar= new Bar();
          bar.setFoo(foo);
          return bar;
       }
    }

<bean id="bar1" class="my.company.BarFactory"
                          factory-method="createBar">
    <constructor-arg ref="foo1"/>
</bean>

<bean id="bar2" class="my.company.BarFactory"
                          factory-method="createBar">
    <constructor-arg ref="foo2"/>
</bean>