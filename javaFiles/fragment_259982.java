public class MultiSelectDialog extends Dialog {
    private final String title;
    private ListView items;
    private List<String> selectedItems;
    private HashMap<String, String> translation;
    private List<String> displayedValues;

    public MultiSelectDialog(Context context, String title, List<String> values,
            HashMap<String, String> translation) {
        super(context);
        this.title = title;
        this.translation = translation;
        if(translation != null) {
            displayedValues = FUtils.collect(translation.entrySet().iterator(),
                    new Converter<HashMap.Entry<String, String>, String>() {
                        public String convert(Entry<String, String> object) {
                            return object.getValue();
                        }
                    });
        }
        else {
            displayedValues = values;
        }
        selectedItems = new LinkedList<String>();
    }

    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(List<String> selectedItems) {
        this.selectedItems.clear();
        this.selectedItems.addAll(selectedItems);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiselect);

        setTitle(title);
        items = (ListView) findViewById(R.id.values);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_multiple_choice, displayedValues);
        items.setAdapter(adapter);
        for(int i = 0; i < adapter.getCount(); ++i) {
            items.setItemChecked(i, false);
        }

        if(selectedItems != null) {
            for(int i = 0; i < selectedItems.size(); ++i) {
                String value = getTranslatedValue(selectedItems.get(i));
                for(int j = 0; j < items.getAdapter().getCount(); ++j) {
                    if(items.getAdapter().getItem(j).equals(value)) {
                        items.setItemChecked(j, true);
                    }
                }
            }
        }

        Button selectAll = (Button) findViewById(R.id.selectAll);
        selectAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i = 0; i < adapter.getCount(); ++i) {
                    items.setItemChecked(i, true);
                }
            }
        });
        Button deselectAll = (Button) findViewById(R.id.deselectAll);
        deselectAll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                for(int i = 0; i < adapter.getCount(); ++i) {
                    items.setItemChecked(i, false);
                }
            }
        });
        Button okButton = (Button) findViewById(R.id.ok);
        okButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectedItems.clear();
                for(int i = 0; i < adapter.getCount(); ++i) {
                    if(items.isItemChecked(i)) {
                        String item = (String) items.getItemAtPosition(i);
                        reverseTranslateAndAdd(item);
                    }
                }
                dismiss();
            }
        });
    }

    private String getTranslatedValue(String key) {
        if(translation == null) {
            return key;
        }
        return translation.get(key);
    }

    private void reverseTranslateAndAdd(String item) {
        if(translation != null) {
            for(Entry<String, String> e : translation.entrySet()) {
                String value = e.getValue();
                if(value.equals(item)) {
                    selectedItems.add(e.getKey());
                    break;
                }
            }
        }
        else {
            selectedItems.add(item);
        }
    }
}