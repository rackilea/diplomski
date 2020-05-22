@Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            try {
                if (key.equals("isGPS_Switch")) {
                    Boolean isGPSSwitch = sharedPreferences.getBoolean(key, false);
                    if (isGPSSwitch) {
                        // START SERVICE
                        getActivity().startService(new Intent(getActivity(), gpsService.class));

                        Intent buttons_visible = new Intent("buttons_visible");
                        buttons_visible.putExtra("btn_imageDisplayGPS", "true");
                        getContext().sendBroadcast(buttons_visible);


                    } else {
                        // STOP SERVICE
                        getActivity().stopService(new Intent(getActivity(), gpsService.class));

                        Intent buttons_visible = new Intent("buttons_visible");
                        buttons_visible.putExtra("btn_imageDisplayGPS", "false");
                        getContext().sendBroadcast(buttons_visible);


                    }
                }
            } catch (Exception ex) {
                Log.e("Preferences", ex.getMessage());
            }
        }
    }