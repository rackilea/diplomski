public class AliasMap<K, V> extends AbstractMap<K, V>
{
    private final Map<K, V> backingMap;
    private final Map<K, K> aliasToRealKey;

    public AliasMap ()
    {
        this( new HashMap<K, V>() );
    }

    public AliasMap ( Map<K, V> backingMap )
    {
        this.backingMap = backingMap;
        aliasToRealKey = new HashMap<K, K>();
    }

    @Override
    public Set<Entry<K, V>> entrySet ()
    {
        return new AliasAwareEntrySet<K, V>( aliasToRealKey, backingMap );
    }

    @Override
    public V put ( K k, V v )
    {
        if ( aliasToRealKey.containsKey( k ) )
        {
            throw new IllegalArgumentException( "An alias '" + k + "' already exists in the map" );
        }
        return backingMap.put( k, v );
    }

    @Override
    public V get ( Object o )
    {
        V v = backingMap.get( o );
        if ( v == null )
        {
            K realKey = aliasToRealKey.get( o );
            if ( realKey == null )
            {
                return null;
            }
            return backingMap.get( realKey );
        }
        return v;
    }

    public void alias ( K realKey, K alias )
    {
        if ( backingMap.containsKey( alias ) )
        {
            throw new IllegalArgumentException( "The key '" + alias + "' already exists in the map" );
        }
        aliasToRealKey.put( alias, realKey );
    }

    private static class AliasAwareEntrySet<K, V> extends AbstractSet<Entry<K, V>>
    {
        private Map<K, K> aliasToRealKey;
        private Map<K, V> backingMap;

        public AliasAwareEntrySet ( Map<K, K> aliasToRealKey, final Map<K, V> backingMap )
        {
            this.aliasToRealKey = aliasToRealKey;
            this.backingMap = backingMap;
        }

        @Override
        public Iterator<Entry<K, V>> iterator ()
        {
            return new AliasAwareEntryIterator<K, V>( backingMap, aliasToRealKey );
        }

        @Override
        public int size ()
        {
            return backingMap.size() + aliasToRealKey.size();
        }

    }

    private static class AliasAwareEntryIterator<K, V> implements Iterator<Entry<K, V>>
    {
        Set<Entry<K, V>> realEntries;
        Set<K> aliasKeys;
        Iterator<Entry<K, V>> realIterator;
        Iterator<K> aliasIterator;

        boolean isRealEntry = true;
        private Map<K, V> backingMap;
        private Map<K, K> aliasToRealKey;

        public AliasAwareEntryIterator ( final Map<K, V> backingMap, Map<K, K> aliasToRealKey )
        {
            this.realEntries = backingMap.entrySet();
            this.aliasKeys = aliasToRealKey.keySet();

            realIterator = realEntries.iterator();
            aliasIterator = aliasKeys.iterator();
            this.backingMap = backingMap;
            this.aliasToRealKey = aliasToRealKey;
        }

        public boolean hasNext ()
        {
            return realIterator.hasNext() || aliasIterator.hasNext();
        }

        public Entry<K, V> next ()
        {
            if ( realIterator.hasNext() )
            {
                return realIterator.next();
            }
            isRealEntry = false;

            final K alias = aliasIterator.next();
            final K realKey = aliasToRealKey.get( alias );
            return new AliasAwareEntry( alias, realKey );
        }

        public void remove ()
        {
            if ( isRealEntry )
            {
                realIterator.remove();
            }
            else
            {
                aliasIterator.remove();
            }
        }

        private class AliasAwareEntry implements Entry<K, V>
        {

            private final K alias;
            private final K realKey;

            public AliasAwareEntry ( K alias, K realKey )
            {
                this.alias = alias;
                this.realKey = realKey;
            }

            public K getKey ()
            {
                return alias;
            }

            public V getValue ()
            {
                return backingMap.get( realKey );
            }

            public V setValue ( V v )
            {
                return backingMap.put( realKey, v );
            }
        }
    }

    public static void main ( String[] args )
    {
        AliasMap<String, String> sm = new AliasMap<String, String>();
        sm.put( "Elvis", "Presley" );

        sm.alias( "Elvis", "Priscilla" );
        System.out.println( sm.get( "Elvis" ) );
        System.out.println( sm.get( "Priscilla" ) );

        sm.put( "Elvis", "Costello" );
        System.out.println( sm.get( "Elvis" ) );
        System.out.println( sm.get( "Priscilla" ) );

        for ( String s : sm.keySet() )
        {
            System.out.println(s);
        }

        for ( Iterator<Entry<String, String>> iterator = sm.entrySet().iterator(); iterator.hasNext(); )
        {
            Entry<String, String> entry = iterator.next();
            System.out.println( entry.getKey() + " : " + entry.getValue() );
            if ( "Priscilla".equals( entry.getKey() ) )
            {
                iterator.remove();
            }
        }

        for ( String s : sm.keySet() )
        {
            System.out.println(s);
        }
    }
}