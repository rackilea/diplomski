static void exceptions(boolean b) {
    try {
        try {
            if (b) throw new FileNotFoundException("FIRST");
            try {
                throw new IOException("SECOND");
            } catch (FileNotFoundException e) {
                System.out.println("This will never been printed out.");
            }
        } catch (FileNotFoundException e) {
            System.out.println(e + " is handled by exceptions().");
            try {
                throw new FileNotFoundException("THIRD");
            } catch (FileNotFoundException fe) {
                System.out.println(fe + " is handled by exceptions() - nested.");
            }
            // will be caught by the nested try/catch at the end.
            throw new IOException("FOURTH");
        }
    } catch (Exception e) {
        System.out.println(e + " is handled by exceptions().");
    }
}