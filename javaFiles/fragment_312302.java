@Service
class SomeService{

    @Autowired
    Parent[] childs; // injecting all Child*

    void doSomethingWithChilds() {
        for(Parent child: childs) {
            child.doFilter(); // invoking their doFilter() impl
            String currentChildName = child.beanName;
            // We now know the name of current child* bean
            // We can use it for manipulating the child* instance
            // This is useful because each child instance will have a different bean name

            if(currentChildName.equals("child2")) {
                // do something special with child2
            }

        }
    }
}