@Override
public void onClick(View view) {
    switch (view.getId()) {
        case R.id.picture: {
            takePicture();
            break;
        }
        case R.id.info: {
            Activity activity = getActivity();
            if (null != activity) {
                new AlertDialog.Builder(activity)
                        .setMessage(R.string.intro_message)
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
            }
            break;
        }
    }
}