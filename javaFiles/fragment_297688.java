public class Main {
    public static void main(String[] args) throws Exception {
        // try block fails and close() fails
        try (T t = new T()) {
            throw new Exception("thrown by try part");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed()[0].getMessage());
        }

        // try block is successful but close() fails
        try (T t = new T()) {
            //
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class T implements AutoCloseable {
    @Override
    public void close() throws Exception {
        throw new Exception("thrown by close");
    }
}