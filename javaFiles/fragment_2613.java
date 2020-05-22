if (!fileDetails.isEmpty()) {

        for (int i = 0; i < fileDetails.size(); i++) {
            CommonUtilities.filePaths.add(fileDetails.get(i).getPath());
            Log.d(Integer.toString(i), fileDetails.get(i).getPath());
        }
    }