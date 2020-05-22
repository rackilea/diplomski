class CallingClass
{
    private SurfaceCreatingClass m_surfacecreatingclass;

    public CallingClass()
    {
        m_surfacecreatingclass = new SurfaceCreatingClass();
        m_surfacecreatingclass.SurfaceCreatedHandler += OnFinished;
        m_surfacecreatingclass.CreateSurface();
    }

    void OnFinished(int iMessageWhat)
    {
        if (iMessageWhat == SurfaceCreatingClass.MSG_SURFACE_CREATED)
        {
            contentWidth = 0;
            contentHeight = 0;
            RequestLayout();
        }
        else
        {
            Log.w("Unknown msg.what: " + iMessageWhat);
        }
    }
}

class SurfaceCreatingClass
{
    public delegate void SurfaceCreatedDelegate(int iWhat);
    public event SurfaceCreatedDelegate SurfaceCreatedHandler;
    public const int MSG_SURFACE_CREATED = 1;

    public void CreateSurface()
    {
        /////////////////////////////
        // Surface creation code here
        // ...
        /////////////////////////////

        if (SurfaceCreatedHandler != null)
            SurfaceCreatedHandler(MSG_SURFACE_CREATED);
    }
}