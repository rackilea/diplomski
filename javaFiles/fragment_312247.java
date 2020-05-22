public void onClick(DialogInterface dialog, int which, boolean isChecked) {
    if (_selection != null) {
        String select = null;
        if (which < _selection.length) _selection[which] = isChecked;

        if (!isAnySelect()) 
            select = _title;
        else 
            select = buildSelectedItemString();

        _proxyAdapter.clear();
        _proxyAdapter.add(select);
        setSelection(0);
    }
    else {
        throw new IllegalArgumentException("Argument 'which' is out of bounds.");
    }
}