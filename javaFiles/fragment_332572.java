package com.basilbourque.example;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;

public class WeakHashMapExercise {

    public static void main ( String[] args ) {
        WeakHashMapExercise app = new WeakHashMapExercise();
        app.doIt();
    }

    private void doIt ( ) {
        Set < UUID > set =
                Collections.synchronizedSet(
                        Collections.newSetFromMap(
                                new WeakHashMap <>()
                        )
                );

        UUID uuid1 = UUID.fromString( "a8ee1e34-cead-11e8-a8d5-f2801f1b9fd1" );
        UUID uuid2 = UUID.fromString( "39bda2b4-5885-4f56-a900-411a49beebac" );
        UUID uuid3 = UUID.fromString( "0b630385-0452-4b96-9238-20cdce37cf55" );
        UUID uuid4 = UUID.fromString( "98d2bacf-3f7f-4ea0-9c17-c91f6702322c" );

        System.out.println( "Size before adding: " + set.size() );

        set.add( uuid1 );
        set.add( uuid2 );
        set.add( uuid3 );
        set.add( uuid4 );

        System.out.println( "Size after adding 4 items: " + set.size() );  // Expect 4.

        set.remove( uuid3 );

        System.out.println( "Size after removing item # 3: " + set.size() );  // Expect 3.

        uuid2 = null;  // Release that UUID to garbage-collection.

        // That released object may still appear in our `Set` until garbage collection actually executes. 
        System.gc(); // Ask the JVM to run the garbage-collection. Only a suggestion, may be ignored.
        try {
            Thread.sleep( 1_000 );  // Wait a moment, just for the heck of it.
        } catch ( InterruptedException e ) {
            e.printStackTrace();
        }

        System.out.println( "Size after making garbage of item # 2: " + set.size() );  // Expect 2.

        for ( UUID uuid : set ) {
            System.out.println( uuid.toString() );
        }


    }
}