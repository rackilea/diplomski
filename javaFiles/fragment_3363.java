@NoArgsConstructor
public class DatabaseEntries {

    @JacksonXmlProperty(localName="Entry")
    @JacksonXmlElementWrapper(localName="Entries")
    @JsonProperty
    private List<DatabaseEntry> databaseEntries = new LinkedList<>();

    public int size(){
        return databaseEntries.size();
    }

    @JsonIgnore
    public List<DatabaseEntry> getAllEntries(){
        Collections.sort(databaseEntries);
        return databaseEntries;
    }

    public void add(DatabaseEntry databaseEntry){
        databaseEntries.add(databaseEntry)  ;
        }

}