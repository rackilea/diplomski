package name.antonsmirnov.zzz.dao.types;

import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.ByteArrayType;

/**
 * ByteArray Type that prefers storing byte[] as BYTE_ARRAY
 */
public class PreferByteArrayType extends ByteArrayType {

    public PreferByteArrayType() {
        super(SqlType.BYTE_ARRAY, new Class[] { byte[].class });
    }

    private static final PreferByteArrayType singleTon = new PreferByteArrayType();

    public static PreferByteArrayType getSingleton() {
        return singleTon;
    }
}