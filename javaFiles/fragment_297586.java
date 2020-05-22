@Entity
        public class User {

            @Id
            @GeneratedValue(strategy=GenerationType.IDENTITY)
            private long id;

            private String name;

            ...

            @ElementCollection
            @CollectionTable(name="USER_SETTINGS")
            @MapKeyColumn(name="SETTINGS_TYPE")
            @Column(name="SETTINGS_VALUE")
            Map<String, Boolean> userSettings = new HashMap<>();