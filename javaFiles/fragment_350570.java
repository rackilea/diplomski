private class MyMap extends SimpleFunction < Long, Long > {
    public Long apply(Long in ) {
        System.out.println("Length is: " + in );
        return in;
    }
}

public void run(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.fromArgs(args).withValidation().create();
    Pipeline p = Pipeline.create(options);

    // Create a PCollection from static objects
    ArrayList < String > strs = new ArrayList < > ();
    strs.add("Neil");
    strs.add("John");
    strs.add("Bob");

    PCollection < String > pc1 = p.apply(Create.of(strs));
    PCollection < Long > count = pc1.apply(Count.globally());
    count.apply(MapElements.via(new MyMap()));

    System.out.println("About to run!");

    p.run().waitUntilFinish();

    System.out.println("Run complete!");
} // run