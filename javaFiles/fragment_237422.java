h.postDelayed(new Runnable()
        {

            @Override
            public void run()
            {
                PersonalPrefs prefs = new PersonalPrefs(getActivity());
                playNewAudio(prefs.getURL());
            }
        }, 1000);