package pfc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassGenerator {

public static BufferedWriter writeClass(String dir, String className) throws IOException {
    BufferedWriter bw1 = new BufferedWriter( new FileWriter( dir + File.separator + className
            + ".java" ) );
    bw1.write( "public class " + className + " {" );
    bw1.newLine( );
    bw1.write( "  private int value;" );
    bw1.newLine( );
    bw1.write( "  public int getValue() {" );
    bw1.newLine( );
    bw1.write( "    return this.value;" );
    bw1.newLine( );
    bw1.write( "  }" );
    bw1.newLine( );
    bw1.write( "  public void setValue(int value) {" );
    bw1.newLine( );
    bw1.write( "    this.value = value;" );
    bw1.newLine( );
    bw1.write( "  }" );
    bw1.newLine( );
    bw1.write( "}" );
    bw1.newLine( );
    bw1.close( );
    return bw1;
}

public static void main(String [] args) throws IOException, ClassNotFoundException,
        NoSuchMethodException, SecurityException, InstantiationException,
        IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    String className = "TestClass";
    String dir = "bin";
    BufferedWriter bw = writeClass( dir , className );

    com.sun.tools.javac.Main.compile( new String [] { dir + File.separator + className
            + ".java" } );

    ClassLoader classLoader1 = ClassGenerator.class.getClassLoader( );
    Class clazz1 = classLoader1.loadClass( className );

    Constructor ctr1 = clazz1.getConstructor( new Class [0] );
    Object testClassInstance = ctr1.newInstance( new Object [0] );
    Method setter1 = clazz1.getMethod( "setValue" , new Class [] { int.class } );
    setter1.invoke( testClassInstance , 12 );

    Method getter1 = clazz1.getMethod( "getValue" , new Class [0] );
    Object result = getter1.invoke( testClassInstance );
    System.out.println( result.toString( ) );
}
}