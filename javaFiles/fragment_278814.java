@Inject
@Optional
public void event(@UIEventTopic("/my/topic") final String value)
{
  if (value != null) {
    // TODO Handle value
  }
}