public class SettingsFragment extends PreferenceFragment implements OnSharedPreferenceChangeListener {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);

            Preference p = getPreferenceManager().findPreference("orientation");
            p.setEnabled(isTablet(getActivity()));
        }

        private boolean isTablet(Context context) {
            int screenLayout = context.getResources().getConfiguration().screenLayout;
            screenLayout &= Configuration.SCREENLAYOUT_SIZE_MASK;

            switch (screenLayout) {
                case Configuration.SCREENLAYOUT_SIZE_SMALL:
                    return false;
                case Configuration.SCREENLAYOUT_SIZE_NORMAL:
                    return false;
                case Configuration.SCREENLAYOUT_SIZE_LARGE:
                    return true;
                case 4: // Configuration.SCREENLAYOUT_SIZE_XLARGE is API >= 9
                    return true;
                default:
                    return false;
            }
        }
        //...................