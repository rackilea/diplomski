public class LastUpdateListener {
@PreUpdate
@PrePersist
public void setLastUpdate(MasterForm form) {
    form.getApplication().setLastUpdate(LocalDateTime.now());
}