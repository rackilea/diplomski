@SQLInsert(sql="INSERT INTO catalog_model_i18n(model_id, locale, name) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE name = VALUES(name)")
@ElementCollection
@MapKeyClass(value = java.util.Locale.class)
@MapKeyColumn(name = "locale")
@CollectionTable(name = "catalog_model_i18n", joinColumns = @JoinColumn(name = "model_id"))
@Column(name = "name")
private Map<Locale, String> names = new HashMap<>();

@SQLInsert(sql="INSERT INTO catalog_model_i18n (model_id, locale, display_name) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE display_name = VALUES(display_name)")
@ElementCollection
@MapKeyClass(value = java.util.Locale.class)
@MapKeyColumn(name = "locale")
@CollectionTable(name = "catalog_model_i18n", joinColumns = @JoinColumn(name = "model_id"))
@Column(name = "display_name")
private Map<Locale, String> displayNames = new HashMap<>();