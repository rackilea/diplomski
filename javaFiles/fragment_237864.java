static void report(String s, CompletableFuture<?> f) {
    f.whenComplete((i,t) -> {
        if(t != null) System.out.println(s+" completed exceptionally with "+t);
        else System.out.println(s+" completed with value "+i);
    });
}