public class Application {
    public static void main(String[] args) {
        System.out.println("My tests ...");
        CompletableFuture<String> futureString = new CompletableFuture<String>();
        futureString.whenComplete((s,e)->System.out.println("one " + s));
        futureString.whenComplete((s,e)->System.out.println("two " + s));
        futureString.whenComplete((s,e)->System.out.println("three " + s));
        System.out.println("do something else; "+ futureString.isDone());
        futureString.complete("step(s)");
        System.out.println("Done " + futureString.isDone());
    }
}