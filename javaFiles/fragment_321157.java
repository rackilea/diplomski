public class EditorPresenterTest {
    @Mock
    private EditorContract.View mView;
    @Mock
    private DataSourceImpl mDataSourceImpl;
    @Mock
    private SharedPreferences sharedPrefs;

    private EditorPresenter editorPresenter;

    @Before
    public void setUpEditorPresenter() {
        MockitoAnnotations.initMocks(this);
        this.editorPresenter = new EditorPresenter(
                sharedPrefs,
                mDataSourceImpl,
                mView);
    }

    @Test
    public void createEditorPresenter_newNote() {
         verify(mView).setPresenter(editorPresenter);
    }

    @Test
    public void showNewNote() {
        editorPresenter.showNewNote();
        String noteColor = "#ef5350"; // or whatever color you want
        String textColor = "#000000"; // or whatever color you want
        when(sharedPrefs.getString(eq("default_note_color"), eq("#ef5350"))).thenReturn(noteColor);
        when(sharedPrefs.getString(eq("default_text_color"), eq("#000000"))).thenReturn(textColor);
        verify(mView).textColor(Color.parseColor(noteColor));
        verify(mView).noteColor(Color.parseColor(textColor));
    }
}