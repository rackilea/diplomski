class T1 {
}

class T2 {
    @Autowired
    T1 t1;
}

public class Main {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(T1.class, T2.class);
        ctx.refresh();
        System.out.println(ctx.getBean(T2.class).t1);
    }
}