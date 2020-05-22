@Transient
private Double Sales_Rs;

@PostLoad
private void onLoad() {
     Sales_Rs = ... //  same logic as in your db function
}