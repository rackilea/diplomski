public interface CakeVisitor<R> {

    R visit(Cake cake); 
    R visit(SaleCake cake);
    R visit(ExampleCake cake);

}