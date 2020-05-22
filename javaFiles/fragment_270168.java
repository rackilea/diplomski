public class View {
    interface Summary {}
    interface SummaryWithRecipients extends Summary {}
}

public class Message {

    @JsonView(View.Summary.class)
    private Long id;

    @JsonView(View.Summary.class)
    private LocalDate created;

    @JsonView(View.Summary.class)
    private String title;

    @JsonView(View.Summary.class)
    private User author;

    @JsonView(View.SummaryWithRecipients.class)
    private List<User> recipients;

    private String body;
}