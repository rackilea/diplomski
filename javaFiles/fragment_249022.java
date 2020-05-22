@ManyToOne
@JoinColumn(name="PREFACE_AUTHOR")
private Author prefaceAuthor;

@ManyToOne
@JoinColumn(name="BOOK_AUTHOR")
private Author bookAuthor;