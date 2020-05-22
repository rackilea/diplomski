public void show() {
    Log.e(TAG, "show");
    cordova.getActivity().runOnUiThread(new Runnable() {
         @Override
         public void run() {
            cordova.getActivity().setContentView(resources.getIdentifier("activity_camera", "layout", packageName));
            cordova.getActivity().getFragmentManager().beginTransaction().replace(resources.getIdentifier("container", "id", packageName), Camera2VideoFragment.newInstance(cordova, callbackContext)).commit();
        }
    });
}

// hide the plugin
public void hide() {
    Log.e(TAG, "hide");
    cordova.getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            Fragment fragment = cordova.getActivity().getFragmentManager().findFragmentById(resources.getIdentifier("container", "id", packageName));
            cordova.getActivity().getFragmentManager().beginTransaction().remove(fragment).commit();
            cordova.getActivity().setContentView(getView());
        }
    });
}