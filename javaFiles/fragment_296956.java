class Poll {
    //....
    @OneToMany(mappedBy="poll")
    private Set<Option> options;
}

class Option {
    //...
    @ManyToOne
    @JoinColumn("poll_id")  // I always like to be explicit on naming :P
    private Poll poll;
}