@Valid
@NotNull
@JsonProperty("database")
private Collection<DataSourceConfig> databases;

public Collection<DataSourceConfig> getDatabase() {
    return databases;
}