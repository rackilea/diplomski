public class EditVendorWorkflow extends EditWorkflow<Vendor, VendorEditor> {

    interface Driver extends  SimpleBeanEditorDriver<Vendor, VendorEditor>{}

    public void initialize(VendorEditor editor) {
        super.initialize(editor, GWT.create(Driver.class));
    }

    @Override
    protected void doSomethingWithEditedObject(Vendor object) {
        // Code specific to class Vendor...
    }
}