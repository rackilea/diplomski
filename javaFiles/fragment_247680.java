generator() {
  database() {
    name { mkp.yield( 'org.jooq.util.postgres.PostgresDatabase' ) }
    inputSchema("public")
  }
[..]