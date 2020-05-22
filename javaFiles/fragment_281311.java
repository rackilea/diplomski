val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
    putExtra(AlarmClock.EXTRA_MESSAGE, message)
    putExtra(AlarmClock.EXTRA_HOUR, hour)
    putExtra(AlarmClock.EXTRA_MINUTES, minutes)
}
if (intent.resolveActivity(packageManager) != null) {
    startActivity(intent)
}