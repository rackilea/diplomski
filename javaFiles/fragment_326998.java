Bundle bundle = new Bundle();
if (mainImageUri != null) {
    bundle.putString("USER_PIC_URI", mainImageUri.toString());
} else {
    bundle.putString("USER_PIC_URI", "");
}
fragment.setArguments(bundle);