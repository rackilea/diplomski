public CustomSwitcher(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.binding = CustomSwitcherBinding.inflate(LayoutInflater.from(context), this, true);
    this.binding.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
        @Override
        public void onPropertyChanged(Observable sender, int propertyId) {
            if (propertyId == BR.item) {
                setVm(binding.getItem());
            }
        }
    });
}

public void setVm(boolean vmVal){
    if (vmVal != this.vm) {
        this.vm = vmVal;
        this.binding.setItem(vm);
        if (this.onValChanged != null) {
            this.onValChanged.onValChanged(this, vmVal);
        }
    }
}