PackageManager pm = getActivity().getPackageManager();
pm.setComponentEnabledSetting(new     ComponentName(getActivity(), CustomLauncherActivity.class), PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

writeSetupFlag(true);
Intent i = new Intent(Intent.ACTION_MAIN);
i.addCategory(Intent.CATEGORY_HOME);
i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
startActivity(i);