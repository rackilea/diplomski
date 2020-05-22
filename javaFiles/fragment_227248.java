@RevisionListener(SystemRevisionListener.class)
@Entity
public class SystemRevision extends AbstractRevision
{
   @Column(nullable = false, updatable = false)
   protected QuartzTriggerHandle job;

   @Column(nullable = false, updatable = false)
   protected Class jobClass;

   ...
}



@RevisionListener(WebRevisionListener.class)
@Entity
public class WebRevision extends AbstractRevision
{
   @ManyToOne(optional = false)
   @JoinColumn(nullable = false, updatable = false)
   protected HttpRequest httpRequest;

   ...
}