boolean hasMenuKey = ViewConfiguration.get(context).hasPermanentMenuKey();
boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

if(!hasMenuKey && !hasBackKey) {

}