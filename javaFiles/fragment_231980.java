Bundle bundle = new Bundle();
DataToSend dataToSend = new DataToSend(activeAudio, channel);
bundle.putParcelable("data", dataToSend);
Intent playIntent = new Intent(activity.getApplicationContext(), 
MusicPlayerService.class);
playIntent.putExtra(bundle);
activity.startService(playIntent);