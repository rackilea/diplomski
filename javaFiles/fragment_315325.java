@Entity
@Table(name = "LANGUAGE")
public class LanguageData extends PersistedAuditedData<Long> {

@Id
@Column
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(name = "ISO6391ALPHA2CODE")
private String iso6391Alpha2Code;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "languageData")
@MapKeyColumn(name = "LANGUAGE_LOCALIZATION_ID")
private Map<Long, LanguageDataLocalization> localizations;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "localizationLanguage")
@MapKeyColumn(name = "LANGUAGE_ID")
private Map<Long, LanguageDataLocalization> languagesLocalized;

/**
 * Private no-arg constructor for reflection-based construction inside JPA providers.
 */
@SuppressWarnings("unused")
private LanguageData() {
    // Fields initialized by JPA.
}

// Plus getters for fields
}