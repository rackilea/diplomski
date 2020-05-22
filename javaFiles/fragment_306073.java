public class MultiAutoCompleteSearchView extends android.support.v7.widget.SearchView { 

    private SearchAutoComplete mSearchAutoComplete; 

    public void initialize() { 
        mSearchAutoComplete = (SearchAutoComplete) 
            findViewById(android.support.v7.appcompat.R.id.search_src_text); 
        this.setAdapter(null); 
        this.setOnItemClickListener(null); 
    } 

    public MultiAutoCompleteSearchView(Context context) { 
        super(context); 
        initialize(); 
    } 

    public MultiAutoCompleteSearchView(Context context, AttributeSet attrs) { 
        super(context, attrs); 
        initialize(); 
    } 

    public MultiAutoCompleteSearchView(Context context, AttributeSet attrs, int defStyleAttr) { 
        super(context, attrs, defStyleAttr); 
        initialize(); 
    } 

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) { 
        mSearchAutoComplete.setOnItemClickListener(listener); 
    } 

    public void setAdapter(ArrayAdapter<?> adapter) { 
        mSearchAutoComplete.setAdapter(adapter); 
    } 
}