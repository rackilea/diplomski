@ElementCollection(fetch=FetchType.EAGER)
@CollectionTable(name="FrameworkUser_Properties")
@MapKeyColumn
public Map<String, String> getProperties() {
           return properties;
}