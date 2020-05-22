@Enumerated(EnumType.ORDINAL)
    @Column(name="status")
    private RSVP rsvpStatus;

    public RSVP getRsvpStatus() {
        return this.rsvpStatus;
    }

    public void setRsvpStatus(RSVP rsvp) {
        this.rsvpStatus = rsvp;
    }