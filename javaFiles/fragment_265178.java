btnStarRecord.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final Date date = new Date();
            final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");

            myRecorder = new MediaRecorder();
            myRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            myRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            myRecorder.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);

            myRecorder.setOutputFile(Environment.getExternalStorageDirectory() + "/myFolder" + "/" + dateFormat.format(date) + ".amr");
            start(v);
        }
    });