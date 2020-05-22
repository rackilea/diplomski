@ManagedBean
@RequestScoped
public class Bean
{
    private UploadedFile m_oDocument;

    public void setDocument(UploadedFile p_oDocument)
    {
        m_oDocument = p_oDocument;
    }

    @UploadedFileNotEmpty
    @UploadedFileSize(max="10000000")
    @UploadedFileExtension(accept="doc,docx,pdf,txt,rtf,xls,xlsx,zip,rar,jpg,jpeg,jpe,bmp,gif,png,csv,ppt,pptx,odp,pic,odt,ods")
    public UploadedFile getDocument()
    {
        return m_oDocument;
    }

    public void onButtonSubmitClick(ActionEvent p_oEvent)
    {
        ...
    }
}