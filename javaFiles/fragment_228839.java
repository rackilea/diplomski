public static void main(String[] args)
{
    StackTraceElement frame = new Exception().getStackTrace()[0];
    System.out.println(frame.getFileName());
    System.out.println(frame.getLineNumber());
}