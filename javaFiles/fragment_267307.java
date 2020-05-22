package com.example;

import java.util.UUID;

/**
 * @author Basil Bourque. Free forever to use at your own risk.
 */
public enum UuidSpecific  {

    NIL( "00000000-0000-0000-0000-000000000000" ),
    TOLERABLE_UNIQUE_CONSTRAINT_VIOLATION( "e8e6528b-e43c-468b-b661-e24f1b64bee6" );

    // Members
    private UUID uuid;

    // Constructor
    UuidSpecific ( String uuidHexArg ) {
        this.uuid = java.util.UUID.fromString( uuidHexArg );
    }

    // Getters
    UUID getUuid ( ) {
        return this.uuid;
    }

}