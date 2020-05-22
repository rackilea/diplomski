// PACKAGE A
// pacakge private
interface View
{
    void methodForPresenter();
}

public class ViewImpl
{
    private m_view = new View()
    {
        @Override
        public void methodForPresenter() {}
    }

    public void methodForClient() {}
}

// PACKAGE B
// client code example
void main()
{
    ViewImpl view = new ViewImpl();
    view.methodForClient(); // ok
    view.methodForPresenter(); // now an error
}