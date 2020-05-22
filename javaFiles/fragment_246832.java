class AsyncTask 
{
public:
    virtual void execute() = 0;
    virtual ~AsyncTask() {}
};


namespace _AsyncTaskInner {
    class CppProxy : public AsyncTask 
    {
    private:
        long LocalNativeRef;
    public:

        CppProxy(long tmpNativeRef)
        {

        }

        void execute()
        {

        }
    };
}