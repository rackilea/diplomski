if (requestCode == VOICE_RECOGNITION_REQUEST_CODE
                && resultCode == RESULT_OK) {
            ArrayList<String> matches = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            wordStr = matches.get(0);
            words = wordStr.split(" ");
            firstWord = words[0];
            secondWord = words[1];
        } // This ends above if

        if (firstWord.equals("open")) {