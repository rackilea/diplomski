String schema = this.datasourceProperties.getProperty("schema");
if (schema == null) {
    schema = "classpath*:schema-"
            + this.datasourceProperties.getProperty("platform", "all")
            + ".sql,classpath*:schema.sql,classpath*:data.sql";
}