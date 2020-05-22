fun createShortCut(){
    val str= ""
    val uri = Uri.parse("http://instagram.com/_u/"+str)
    val instagramIntent = Intent(Intent.ACTION_VIEW,uri)
    instagramIntent.setPackage("com.instagram.android")
    val icon = IconCompat.createWithResource(this,R.drawable.ic_launcher_background)
    val pinShortcutInfo = ShortcutInfoCompat.Builder(this, "shortcutID")
                .setIcon(icon)
                .setShortLabel("MyShortcut")
                .setIntent(instagramIntent)
                .build()
    ShortcutManagerCompat.requestPinShortcut(this,pinShortcutInfo,null)
}