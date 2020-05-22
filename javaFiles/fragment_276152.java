public class Baker {
    private final CakeVisitor<Void> cakeHandler = new CakeVisitor<Void>(){

        @Override
        public Void visit(Cake cake) {
            putOnTable(cake);
            return null;
        }

        @Override
        public Void visit(SaleCake cake) {
            giveToCustomer(cake);
            return null;
        }

        @Override
        public Void visit(ExampleCake cake) {
            putOnShelf(cake);
            return null;
        }

    };

    Cake bakeCake(Cake cake){
       return processedCake(new Cake(cake));
    }

    SaleCake bakeSaleCake(Cake cake, String owner){
       return processedCake(new SaleCake(cake, owner));
    }

    ExampleCake bakeExampleCake(Cake cake, String location){
       return processedCake(new ExampleCake(cake, location));
    }

    void handleCake(Cake cake){
        cake.accept(cakeHandler);
    }

    private <C extends Cake> C processedCake(C cake){
        mixIngredients(cake);
        putCakeInOven(cake);
        putIcing(cake);
        return cake;
    }
}