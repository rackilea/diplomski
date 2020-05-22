assertTrue(videoView.isPlaying());
     MediaPlayer.OnCompletionListener completionListener = videoView.getOnCompletionListener();
     completionListener.onCompletion(mock(MediaPlayer.class));
     Intent intent = screenSplash.getNextStartedActivity();
     assertNull(intent);
     assertEquals(ChooseTeamActivity.class.getName(), intent.getComponent().getClassName());