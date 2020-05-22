public class ServiceRequestArgs<T extends ICommand> {

    private Class<T> m_token;
    private ICommand m_listener;

    public ServiceRequestArgs(Class<T> cmdClass, ICommand listener)
    {
        m_token = cmdClass;
        m_listener = listener;
    }

    public Class<T> getClassToken()
    {
        return m_token;
    }

    public IFileUploadListener getListener()
    {
        return m_listener;
    }
}