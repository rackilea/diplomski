public class MusicIntentReceiver extends WakefulBroadcastReceiver {
private int headsetSwitch = 1;


@Override
public void onReceive(Context context, Intent intent) {


    if (intent.getAction().equals(android.media.AudioManager.ACTION_AUDIO_BECOMING_NOISY)) {


        Toast.makeText(context, MyApplication.getContext().getResources().getString (R.string.aptxt15), Toast.LENGTH_SHORT).show();
        intent = new Intent(context, ReproductorDialog.ServicioCanciones.class);
        intent.putExtra("do_action", "pause_cascos");
        context.startService(intent);


    } else if (intent.getAction().equals(Intent.ACTION_MEDIA_BUTTON)) {

        KeyEvent keyEvent = (KeyEvent) intent.getExtras().get(Intent.EXTRA_KEY_EVENT);
        if (keyEvent.getAction() != KeyEvent.ACTION_DOWN)
            return;

        switch (keyEvent.getKeyCode()) {
            case KeyEvent.KEYCODE_HEADSETHOOK:


            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
                intent = new Intent(context, ReproductorDialog.ServicioCanciones.class);
                intent.putExtra("do_action", "pause");
                context.startService(intent);
                //   context.startService(new Intent(MusicService.ACTION_TOGGLE_PLAYBACK));
                break;
            case KeyEvent.KEYCODE_MEDIA_PLAY:
                //  context.startService(new Intent(MusicService.ACTION_PLAY));
                intent = new Intent(context, ReproductorDialog.ServicioCanciones.class);
                intent.putExtra("do_action", "pause");
                context.startService(intent);
                break;
            case KeyEvent.KEYCODE_MEDIA_PAUSE:
                //  context.startService(new Intent(MusicService.ACTION_PAUSE));
                intent = new Intent(context, ReproductorDialog.ServicioCanciones.class);
                intent.putExtra("do_action", "pause");
                context.startService(intent);
                break;
            case KeyEvent.KEYCODE_MEDIA_STOP:
                //  context.startService(new Intent(MusicService.ACTION_STOP));
                break;
            case KeyEvent.KEYCODE_MEDIA_NEXT:
                intent = new Intent(context, ReproductorDialog.ServicioCanciones.class);
                intent.putExtra("do_action", "next");
                context.startService(intent);
                break;
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                // TODO: ensure that doing this in rapid succession actually plays the
                // previous song
                //   context.startService(new Intent(MusicService.ACTION_REWIND));
                intent = new Intent(context, ReproductorDialog.ServicioCanciones.class);
                intent.putExtra("do_action", "previous");
                context.startService(intent);
                break;
        }
    }
}
}