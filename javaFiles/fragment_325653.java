class D {
    public static void main(String[] args) {
        // static context
        D a = new D() {
            // only non-static methods and fields
            @Override
            void j() {
                // non-static context - possible to use  'super' and 'this' keywords
            }
        };
    }

    void j() {
        // non-static context - possible to use  'super' and 'this' keywords
    }
}