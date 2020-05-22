if (currentPanel != mCurrentPanel)
{
    if (mCurrentPanel != null)
    {
        mOuterPanel.remove(mCurrentPanel);
    }
    mCurrentPanel = currentPanel;
    mOuterPanel.add(mCurrentPanel);
}