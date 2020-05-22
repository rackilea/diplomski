import java.nio.ByteBuffer;

public final class SerializerHelper {

   public static void putString( String s, ByteBuffer target ) {
      final byte[] bytes = s.getBytes();
      target.putInt( bytes.length );
      target.put( bytes );
   }

   public static void putBoolean( boolean value, ByteBuffer target ) {
      target.put((byte)( value ? 1 : 0 ));
   }

   public static boolean getBoolean( ByteBuffer source ) {
      return source.get() != 0;
   }

   public static String getString( ByteBuffer source ) {
      final int len = source.getInt();
      final byte[] bytes = new byte[len];
      source.get( bytes );
      return new String( bytes );
   }
}