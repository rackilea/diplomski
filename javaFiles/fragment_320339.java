CREATE USER (
    ...,
    notification_id,
    ...
)

class Notification {
    @OneToMany
    @JoinColumn(name="notification_id")
    private User user;
}