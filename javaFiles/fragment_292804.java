public static boolean play(String file) {
    if(currentPackage.containsKey(file)) {
        sound = s_manager.get(currentPackage.get(file), Sound.class);
        sound.play();
        return true;
    }
    return false;
}