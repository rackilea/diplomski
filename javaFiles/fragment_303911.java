import java.io.*;
class Test
    {
    public static void main(String[] args)  throws Exception
        {

        ByteArrayOutputStream baos =new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(baos);
        dos.writeFloat(0f);
        System.err.println(baos.toByteArray().length);
        }
    }

$ javac Test.java 
$ java Test 
4