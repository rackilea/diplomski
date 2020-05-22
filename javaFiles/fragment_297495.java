// This class doesn't translate into a table; it's just a base class that provides
// an ID for all other entities, and perhaps (down the road) other common fields as
// well.
@MappedSuperClass
public class BaseModel {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}

@Entity
@AttributeOverrides({
        @AttributeOverride(name="id", column=@Column(name="word_id"))
})
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name="words")
public class Word extends BaseModel {
    // How do I force Word.getId() to be "words_id"?

    @Column(name="word_text")
    private String text;

    @Column(name="word_length")
    private Integer length;

    // But how do I make this the ID of a word_types record?
    //@Column(name="")
    @ManyToOne
    @JoinColumn(name="word_type_id", referencedColumnName="word_type_id")
    private WordType type;

    @Column(name="word_definition")
    private String definition;

    // The words table doesn't have any synonyms or antonyms.
    // Rather there is a many-to-many relationship between
    // a word and its synonyms and its antonyms...
    @ManyToMany()
    //use the below annotation if you want to set the names of the columns
    //    @JoinTable(joinColumns = @JoinColumn(name="word_id")},//column in this entity
    //          inverseJoinColumns = {@JoinColumn(name="synonym_id")})//column in the table of the set.
    private List<Word> synonyms;

    //@Column(name="???")
    @ManyToMany()
    //use the below annotation if you want to set the names of the columns
    //    @JoinTable(joinColumns = @JoinColumn(name="word_id")},//column in this entity
    //          inverseJoinColumns = {@JoinColumn(name="antonym_id")})//column in the table of the set.
    private List<Word> antonyms;

    // Getters, setters, ctors omitted for brevity...
}

// Not sure what to annotate this table with, because there is not
// base_lookup table or anything like that...
@MappedSuperClass
public class BaseLookup extends BaseModel {
    private String label;
    private String description;
    private String tag;

    // Getters, setters, ctors omitted for brevity...
}

// Furthermore, here, in the case of WordType, I'd like to force the parent
// fields to be "word_type_label", "word_type_description", and "word_type_tag";
// however, other BaseLookup subclasses should be able to force those same fields
// to map/bind to other tables with other field names.
//
// For example, I might some day want a Color POJO relating to a colors table with
// the following fields: color_label, color_description and color_tag, etc.
@Entity
    // How do I force WordType.getId() to be word_type_id?
    // this is how:
@AttributeOverrides({
    @AttributeOverride(name="id", column=@Column(name="word_type_id")),
    @AttributeOverride(name="label", column=@Column(name="word_type_label")),
    @AttributeOverride(name="description", column=@Column(name="word_type_description")),
    @AttributeOverride(name="tag", column=@Column(name="word_type_tag"))
})
public class WordType extends BaseLookup {


    public WordType(String label, String description, String tag) {
        super(label, description, tag);
    }
}