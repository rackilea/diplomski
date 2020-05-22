import org.hibernate.annotations.OptimisticLock;

/* ... */

@OptimisticLock(excluded=true)
private B fieldB;