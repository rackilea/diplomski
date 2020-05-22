public aspect IServiceAspect {
    private IService happy = new HappyService(); // Assuming these are stateless services
    private IService sad = new SadService();     // that can be shared.

    // The pointcut is inside an IService implementation, and is a call to the a() method
    pointcut aCall(): within(IService+) && call(* IService.a());

    pointcut bCall(): within(IService+) && call(* IService.b());

    around(): aCall() && !within(HappyService) { // To avoid infinite recursion
        return happy.a();
    }

    around(): bCall() && !within(SadService) {
        return sad.b();
    }
}