public class Category {
    ...
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "targetId")
    private TranslationTarget target;
}

public class TranslationTarget {
    @Id @GeneratedValue
    private Long id;

    @OneToMany
    @JoinColumn(name = "targetId")
    private Set<TranslatableText> texts;
}