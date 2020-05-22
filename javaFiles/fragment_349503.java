private RefreshJob              m_refreshJob = new RefreshJob();   
private Text                    m_filterText;
void hookModifyListener()
{
    m_filterText.addModifyListener(new ModifyListener()
    {
        public void modifyText(ModifyEvent e)
        {
            m_refreshJob.cancel();
            m_refreshJob.schedule(500);
        }
    });
}