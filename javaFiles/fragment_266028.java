public class SupplierEditor extends Composite implements LeafValueEditor<SupplierCode> {
    interface SupplierEditorUiBinder extends UiBinder<Widget, SupplierEditor> {
    }

    private static SupplierEditorUiBinder uiBinder = GWT.create(SupplierEditorUiBinder.class);

    @UiField(provided = true)
    ValueListBox<SupplierCode> codes;

    public SupplierEditor() {
        codes = new ValueListBox<>(new AbstractRenderer<SupplierCode>() {
            @Override
            public String render(SupplierCode object) {
                return object == null ? "" : object.toString();
            }
        });

        initWidget(uiBinder.createAndBindUi(this));

        codes.setAcceptableValues(Arrays.asList(SupplierCode.values()));
    }

    @Override
    public SupplierCode getValue() {
        return codes.getValue();
    }

    @Override
    public void setValue(SupplierCode value) {
        codes.setValue(value);
    }
}