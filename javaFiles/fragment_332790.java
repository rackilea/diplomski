enum Category {
    Approved, Suppressed, Rejected;

enum Group {
    ApprovedGroup(Category.Approved),
    SuppressedGroup(Category.Suppressed),
    BlockRejectedGroup(Category.Rejected),
    ActionRejectedGroup(Category.Rejected);

    Group( Category category ){...}

    Category getCategory(){...}
}