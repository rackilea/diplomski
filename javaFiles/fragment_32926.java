CheckBox checkbox = new CheckBox();
    LayoutParams checkbox_layoutparams = new GridView.LayoutParams(
        wrap_content,
        wrap_content);
    checkbox_layoutparams.addRule(GridView.'your rule')://add rules if need be
    grid.addView(checkbox,checkbox_layoutparams);