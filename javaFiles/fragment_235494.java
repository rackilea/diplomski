private boolean checkSdCardPermission() {
    boolean flag = false;
    try {
        EnvironmentSDCard.Device[] devices = EnvironmentSDCard.getExternalStorage(MainActivity.this);
        for (EnvironmentSDCard.Device d : devices) {
            if (d.getType().equals(EnvironmentSDCard.TYPE_SD) || d.getType().contains(EnvironmentSDCard.TYPE_UNKNOWN) || d.getType().contains(EnvironmentSDCard.TYPE_USB)) {
                flag = d.isAvailable();
                if (flag)
                    break;
            }
        }
    } catch (Exception e) {
    }
    return flag;
}