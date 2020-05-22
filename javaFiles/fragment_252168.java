static void myMethod(int n) {
    try {
        switch (n) {
            case 1:
                System.out.println("1st case");
                return;
            case 3:
                System.out.println("3rd case");
                throw new RuntimeException("3!");
            case 4:
                System.out.println("4th case");
                throw new Exception("4!");
            case 2:
                System.out.println("2nd case");
        }
    } catch (RuntimeException e) {
        System.out.print("RuntimeException: ");
        System.out.println(e.getMessage());
    } catch (Exception e) {
        System.out.print("Exception: ");
        System.out.println(e.getMessage());
    } 
    finally {
        System.out.println("try-block entered.");
    }
}