function vibrateOn(){
    audio.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,
            AudioManager.VIBRATE_SETTING_ON);
    audio.setVibrateSetting(AudioManager.VIBRATE_TYPE_NOTIFICATION,
            AudioManager.VIBRATE_SETTING_ON);
}

function vibrateOff(){
    audio.setVibrateSetting(AudioManager.VIBRATE_TYPE_RINGER,
            AudioManager.VIBRATE_SETTING_OFF);
    audio.setVibrateSetting(AudioManager.VIBRATE_TYPE_NOTIFICATION,
            AudioManager.VIBRATE_SETTING_OFF);
}