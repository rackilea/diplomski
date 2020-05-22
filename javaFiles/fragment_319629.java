public class Super {
    private final Object finalizerGuardian = new Object() {
            @Override
            protected void finalize() {
                Super.this.doFinalize();
            }
    };

    private void doFinalize() {
        System.out.println("Super finalize");
    }
}