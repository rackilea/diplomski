private static void runJustBeforeBeingDrawn(final View view, final Runnable runnable)
{
    final ViewTreeObserver vto = view.getViewTreeObserver();
    final OnPreDrawListener preDrawListener = new OnPreDrawListener()
    {
        @Override
        public boolean onPreDraw()
        {
            runnable.run();
            final ViewTreeObserver vto = view.getViewTreeObserver();
            vto.removeOnPreDrawListener(this);
            return true;
        }
    };
    vto.addOnPreDrawListener(preDrawListener);
}