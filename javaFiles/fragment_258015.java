public class Demo
{

    public static class Philosopher
        extends Thread
    {

        String name;

        int nr;

        Fork left, right;


        public Philosopher( String name, int nr, Fork left, Fork right )
        {
            this.nr = nr;
            this.name = name;
            this.left = left;
            this.right = right;
            System.out.println( "NR " + nr + "  " + left + " " + right );
        }


        @Override
        public void run()
        {
            // while ( true )
            try {
                Fork minF = Fork.min( left, right );
                Fork maxF = Fork.max( left, right );

                synchronized ( minF ) {
                    if ( ! minF.used ) {
                        minF.used = true;
                        System.out.println( "P" + nr + " took fork " + minF );
                    } else {
                        while ( minF.used )
                            // <- YOU NEED TO CHECK THIS IN A LOOP
                            minF.wait();
                        minF.used = true;
                        System.out.println( "I waited and took fork " + minF ); // why it is never PRINTEDDD???
                    }
                }
                synchronized ( maxF ) {
                    if ( ! maxF.used ) {
                        maxF.used = true;
                        System.out.println( "P" + nr + " took fork " + maxF );
                    } else {
                        while ( maxF.used )
                            // <- YOU NEED TO CHECK THIS IN A LOOP
                            maxF.wait();
                        maxF.used = true;
                        System.out.println( "I waited and took fork " + maxF ); // why it is never PRINTEDDD??
                    }
                }

                System.out.println( "I am eating right now" + this );
                eating();
                System.out.println( "P" + nr + " I have eaten  I am giving back the forks" );

                synchronized ( minF ) {
                    minF.used = false;
                    System.out.println( "P" + nr + " NOTIFY fork" + minF );
                    minF.notify();
                }

                synchronized ( maxF ) {
                    maxF.used = false;
                    System.out.println( "P" + nr + " NOTIFY fork" + maxF );
                    maxF.notify();
                }
            } catch ( Exception e ) {
                // ignore
            }
        }


        public void eating()
            throws InterruptedException
        {
            int time = (int) ( Math.random() * 2000 );

            for ( int i = 0; i < 5; i ++ ) {
                System.out.println( "P" + nr + " " + i );
                Thread.sleep( time / 5 );
            }
        }


        public String toString()
        {
            return "Philosopher " + nr;
        }


        public static void startPhilosophers( Philosopher[] f )
        {
            for ( int i = f.length - 1; i >= 0; i -- ) {
                f[ i ].start();
            }
        }

    }

    public static class Fork
    {

        boolean used;

        int nr;


        public Fork( boolean used, int nr )
        {
            this.used = used;
            this.nr = nr;
        }


        @Override
        public String toString()
        {
            return "F" + nr;
        }


        public static Fork min( Fork l, Fork p )
        {
            if ( l.nr < p.nr )
                return l;
            return p;
        }


        public static Fork max( Fork l, Fork p )
        {
            if ( l.nr > p.nr )
                return l;
            return p;
        }


        public static Fork[] getArrayOfForks()
        {
            Fork[] t = new Fork[ 5 ];
            for ( int i = 0; i < t.length; i ++ ) {
                t[ i ] = new Fork( false, ( i + 1 ) );
            }
            return t;
        }
    }


    public static void main( String[] args )
    {
        Fork[] t = Fork.getArrayOfForks();
        Philosopher[] f =
            { new Philosopher( "philosopher 1", 1, t[ 0 ], t[ 4 ] ), new Philosopher( "philosopher 2", 2, t[ 1 ], t[ 0 ] ),
                new Philosopher( "philosopher 3", 3, t[ 2 ], t[ 1 ] ), new Philosopher( "philosopher 4", 4, t[ 3 ], t[ 2 ] ),
                new Philosopher( "philosopher 5", 5, t[ 4 ], t[ 3 ] ), };
        Philosopher.startPhilosophers( f );
    }

}