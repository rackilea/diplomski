public class LString implements Comparable<LString>
{
    Node front;
    int size;

    //Creating a node class
    private static class Node
    {
        char data;
        Node next;

        public Node()
        {
        }

        public Node( char newData )
        {
            this.data = newData;
        }

        public Node( char newData, Node newNext )
        {
            this.data = newData;
            this.next = newNext;
        }
    }

    //Constructors
    public LString()
    {
        this.size = 0;
        this.front = null;
    }

    public LString( String original )
    {
        this.size = original.length();
        if ( original.length() > 0 )
        {

            this.front = new Node( original.charAt( 0 ) );
            Node curr = this.front;

            for ( int i = 1; i < original.length(); i++ )
            {
                curr.next = new Node( original.charAt( i ) );
                curr = curr.next;
            }
        }
    }

    // Length method, returns the length of LString
    public int length()
    {
        return this.size;
    }

    // compareTo method, compares this LString to anotherLString, returns 0 if equal,
    // -1 if lexicogrpahically less, and 1 if lexicographically greater
    public int compareTo( LString anotherLString )
    {
        int len1 = length();
        int len2 = anotherLString.length();
        int lim = Math.min( len1, len2 );
        // char v1 = front.data;
        //   char v2 = anotherLString.front.data;
        Node cn1 = front;
        Node cn2 = anotherLString.front;

        int k = 0;
        while ( k < lim )
        {
            char c1 = cn1.data;
            char c2 = cn2.data;
            if ( c1 != c2 )
            {
                return c1 - c2;
            }
            k++;
            cn1 = cn1.next;
            cn2 = cn2.next;
        }

        return len1 - len2;
    }

    // a boolean equals method that returns true if LString and other are the same, false if not
    public boolean equals( Object other )
    {
        if ( this == other )
        {
            return true;
        }
        if ( other instanceof LString )
        {
            LString anotherLString = ( LString ) other;
            int n = length();
            if ( n == anotherLString.length() )
            {
                Node n1 = front;
                Node n2 = anotherLString.front;
                while ( n1 != null )
                {
                    if ( n1.data != n2.data )
                    {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

    // charAt returns the character of LString at the argument index
    public char charAt( int index )
    {
        if ( ( index < 0 ) || ( index >= this.length() ) )
        {
            throw new IndexOutOfBoundsException( "bad index" );
        }

        Node curNode = front;
        for ( int i = 0; i < this.length(); i++, curNode = curNode.next )
        {
            if ( i == index )
            {
                return curNode.data;
            }
        }

        throw new IllegalStateException();
    }
}