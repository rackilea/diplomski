public CustomSwitcher(Context context, AttributeSet attrs) {
    super(context, attrs);
    this.binding = CustomSwitcherBinding.inflate(LayoutInflater.from(context), this, true);
}

public void setVm(boolean vmVal){
    this.vm = vmVal;
    this.binding.setItem(vm);
}