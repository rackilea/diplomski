StateListDrawable stateListDrawable= new StateListDrawable();
    stateListDrawable.addState(new int[] {android.R.attr.state_pressed}, new ColorDrawable(getContext().getResources().getColor(R.color.anycolor)));
    stateListDrawable.addState(new int[] {android.R.attr.state_focused}, new ColorDrawable(getContext().getResources().getColor(R.color.anycolor)));
    stateListDrawable.addState(new int[] {android.R.attr.state_selected}, new ColorDrawable(getContext().getResources().getColor(R.color.anycolor)));
    stateListDrawable.addState(new int[] {}, new ColorDrawable(getContext().getResources().getColor(R.color.anycolor)));

    view.setBackgroundDrawable(stateListDrawable);