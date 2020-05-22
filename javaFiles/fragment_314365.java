@Inject
EPartService partService;

...

MPart activePart = partService.getActivePart();

Object part = activePart.getObject();

if (part instanceof MyClass)
 {
    ((MyClass)part).setValue(xxxx);
 }