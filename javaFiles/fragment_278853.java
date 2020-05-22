JSONArray result = createJsonObjects(persons, "name", "name")

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

public static JSONArray createJsonObjects( List< ? > objs, String propertyNames, String jsonKeys )
{
    Assert.hasText( propertyNames );
    Assert.notNull( objs );

    JSONArray result = new JSONArray();
    String[] propertyNameArray = propertyNames.split( ";" );
    String[] jsonKeysArray = propertyNameArray;
    if ( StringUtils.hasText( jsonKeys ) )
    {
        jsonKeysArray = jsonKeys.split( ";" );
    }

    Assert.isTrue( jsonKeysArray.length == propertyNameArray.length );
    try
    {
        Method[] methods = new Method[ propertyNameArray.length ];
        for ( Object obj : objs )
        {
            for ( int i = 0; i < propertyNameArray.length; i++ )
            {
                methods[ i ] = BeanUtils.getPropertyDescriptor( obj.getClass(),
                                                                propertyNameArray[ i ] ).getReadMethod();
            }
            JSONObject json = new JSONObject();
            for ( int i = 0; i < propertyNameArray.length; i++ )
            {
                if ( obj != null )
                    json.element( jsonKeysArray[ i ],
                                  ReflectionUtils.invokeMethod( methods[ i ], obj ) );
            }
            result.add( json );
        }

    }
    catch ( Exception e )
    {
        throw new RuntimeException( e );
    }

    return result;
}