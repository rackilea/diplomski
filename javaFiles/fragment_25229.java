public class MyMediaController : MediaController
{

    private FrameLayout anchorView;


    public MyMediaController(Context context, FrameLayout anchorView) : base(context)
    {
        this.anchorView = anchorView;
    }


    protected override void OnSizeChanged(int xNew, int yNew, int xOld, int yOld)
    {
        base.OnSizeChanged(xNew, yNew, xOld, yOld);

        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams)anchorView.LayoutParameters;
        lp.SetMargins(0, 0, 0, yNew);

        anchorView.LayoutParameters = lp;
        anchorView.RequestLayout();
    }
}