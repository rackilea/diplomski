BitSet bi = new BitSet(6);

            bi.set(1);
            bi.set(3);
            bi.set(4);
            StringBuilder s = new StringBuilder();
            for( int i = 0; i < bi.length();  i++ )
            {
                s.append( bi.get( i ) == true ? 1: 0 );
            }

            System.out.println( s );