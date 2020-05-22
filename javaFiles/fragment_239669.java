Form extends AbstractComponent {
   ...
   @Override
   protected void findComponent() {...}


Panel extends AbstractComponent  {
   ...
   @Override
   protected void findComponent() {...}
}

public abstract class AbstractCOmponent {
   protected abstract void findComponent();
}