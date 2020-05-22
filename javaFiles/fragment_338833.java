public final class ValidatingUnmarshallerListener
        extends Unmarshaller.Listener
{
    private final ValidationEventHandler validationEventHandler;

    public ValidatingUnmarshallerListener(
            ValidationEventHandler validationEventHandler)
    {
        this.validationEventHandler = validationEventHandler;
    }

    @Override
    public void afterUnmarshal(Object target, Object parent)
    {
        if (target == null
                || !(target instanceof CanBeValidated))
        {
            return;
        }

        CanBeValidated v = (CanBeValidated) target;
        Collection<Throwable> validationErrors = v.validate();

        for (Throwable t : validationErrors)
        {
            ValidationEvent event = new ValidationEventImpl(
                    ValidationEvent.ERROR,
                    t.getLocalizedMessage(),
                    null,
                    t);

            this.validationEventHandler.handleEvent(event);
        }
    }
}