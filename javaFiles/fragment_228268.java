package org.foobar.persistence;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

public class PGConstrainedImplicitNamingStrategy extends ImplicitNamingStrategyComponentPathImpl {
private static final int POSTGRES_IDENTIFIER_MAXLENGTH = 63;
public static final PGConstrainedImplicitNamingStrategy INSTANCE = new PGConstrainedImplicitNamingStrategy();

public PGConstrainedImplicitNamingStrategy() {

}

@Override
protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
    return buildingContext.getMetadataCollector()
            .getDatabase()
            .getJdbcEnvironment()
            .getIdentifierHelper()
            .toIdentifier( stringForm.substring( 0, Math.min( POSTGRES_IDENTIFIER_MAXLENGTH, stringForm.length() ) ) );

}}