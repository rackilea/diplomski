editText.SetEditableFactory(new NoCopyEditableFactory());

private class NoCopyEditableFactory : EditableFactory // Editable.Factory in Java
{
    public override IEditable NewEditable(ICharSequence source) => (IEditable)source;
}