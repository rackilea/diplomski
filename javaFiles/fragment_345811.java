@Embedded
@AttributeOverrides({
        @AttributeOverride(name="code",column=@Column(name="day_code")),
        @AttributeOverride(name="desc",column=@Column(name="day_desc"))})
private Courses daycourse;

@Embedded
@AttributeOverrides({
        @AttributeOverride(name="code",column=@Column(name="eve_code")),
        @AttributeOverride(name="desc",column=@Column(name="eve_desc"))})
private Courses evecourse;