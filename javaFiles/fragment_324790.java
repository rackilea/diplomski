public abstract class RewrittenObservable {
     // ...
     public void <T extends Event> notify(T event) {
         observer.update(this, event);
     }
}