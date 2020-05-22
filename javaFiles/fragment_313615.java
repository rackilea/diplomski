@PostConstruct
public void postConstruct(Composite parent)
{
   Composite comp = new Composite(parent, SWT.NONE);
   comp.setLayout(new GridLayout());

  ....
}