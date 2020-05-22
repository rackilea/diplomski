import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;


public class PropertiesVerifier
{
    private final Map<String, PropertyInfo> optionalInfo;
    private final Map<String, PropertyInfo> requiredInfo;

    {
        optionalInfo = new HashMap<String, PropertyInfo>();
        requiredInfo = new HashMap<String, PropertyInfo>();
    }

    public PropertiesVerifier(final PropertyInfo[] infos)
    {
        for(final PropertyInfo info : infos)
        {
            final Map<String, PropertyInfo> infoMap;

            if(info.isRequired())
            {
                infoMap = requiredInfo;
            }
            else
            {
                infoMap = optionalInfo;
            }

            infoMap.put(info.getName(), info);
        }
    }

    public void verifyProperties(final Properties properties)
    {
        for(final Entry<Object, Object> property : properties.entrySet())      
        {
            final String key;
            final String value;

            key   = (String)property.getKey();
            value = (String)property.getValue();

            if(!(isValid(key, value)))
            {
                throw new IllegalArgumentException(value + " is not valid for: " + key);
            }
        }
    }

    public boolean isRequired(final String key)
    {
        return (requiredInfo.get(key) != null);
    }

    public boolean isOptional(final String key)
    {
        return (optionalInfo.get(key) != null);
    }

    public boolean isKnown(final String key)
    {
        return (isRequired(key) || isOptional(key));
    }

    public Class getType(final String key)
    {
        final PropertyInfo info;

        info = getPropertyInfoFor(key);

        return (info.getType());
    }

    public boolean isValid(final String key,
                           final String value)
    {
        final PropertyInfo info;

        info = getPropertyInfoFor(key);

        return (info.verify(value));
    }

    private PropertyInfo getPropertyInfoFor(final String key)
    {
        PropertyInfo info;

        info = requiredInfo.get(key);

        if(info == null)
        {
            info = optionalInfo.get(key);

            if(info == null)
            {
                // should be a better exception maybe... depends on how you 
                // want to deal with it
                throw new IllegalArgumentException(key + " 
                                                   is not a valid property name");
            }
        }

        return (info);
    }

    protected final static class PropertyInfo
    {
        private final String name;
        private final boolean required;
        private final Class clazz;
        private final Verifier verifier;

        protected PropertyInfo(final String   nm,
                               final boolean  mandatory,
                               final Class    c)
        {
            this(nm, mandatory, c, getDefaultVerifier(c));
        }

        protected PropertyInfo(final String   nm,
                               final boolean  mandatory,
                               final Class    c,
                               final Verifier v)
        {
            // check for null
            name     = nm;
            required = mandatory;
            clazz    = c;
            verifier = v;
        }

        @Override
        public int hashCode()
        {
            return (getName().hashCode());
        }

        @Override
        public boolean equals(final Object o)
        {
            final boolean retVal;

            if(o instanceof PropertyInfo)
            {
                final PropertyInfo other;

                other  = (PropertyInfo)o;
                retVal = getName().equals(other.getName());
            }
            else
            {
                retVal = false;
            }

            return (retVal);
        }

        public boolean verify(final String value)
        {
            return (verifier.verify(value));
        }

        public String getName()
        {
            return (name);
        }

        public boolean isRequired()
        {
            return (required);
        }

        public Class getType()
        {
            return (clazz);
        }
    }

    private static Verifier getDefaultVerifier(final Class clazz)
    {
        final Verifier verifier;

        if(clazz.equals(Boolean.class))
        {
            // shoudl use a singleton to save space...
            verifier = new BooleanVerifier();
        }
        else
        {
            throw new IllegalArgumentException("Unknown property type: " + 
                                               clazz.getCanonicalName());
        }

        return (verifier);
    }

    public static interface Verifier
    {
        boolean verify(final String value);
    }

    public static class BooleanVerifier
        implements Verifier
    {
        public boolean verify(final String value)
        {
            final boolean retVal;

            if(value.equalsIgnoreCase("true") ||
               value.equalsIgnoreCase("false"))
            {
                retVal = true;
            }
            else
            {
                retVal = false;
            }

            return (retVal);
        }
    }
}