query.fromLocalDatastore().findInBackground()
                .continueWithTask((task) -> {
                    ParseException error = (ParseException) task.getError();
                    if (error != null || task.getResult().size() == 0) {
                        return query.fromNetwork().findInBackground();
                    }
                    Log.d("Cache", "" + task.getResult().size());
                    return task;
                }, Task.UI_THREAD_EXECUTOR)
                .continueWithTask((task) -> {
                    // Update UI with results ...
                    Log.d("Network", "" + task.getResult().size());
                    ParseException error = (ParseException) task.getError();
                    if (error == null) {
                        ParseObject.pinAllInBackground(task.getResult());
                    }
                    return task;
                }, Task.UI_THREAD_EXECUTOR);