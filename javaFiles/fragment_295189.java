WorkManager.getInstance().getStatusById(workerJor.getId())
        .observe(lifecycleOwner, status -> {
    if (status != null && status.getState().isFinished()) {
        String refreshDataPeriod = status.getOutputData().getString("refreshDataPeriod");
        Log.i("getting the data","on period"+refreshDataPeriod);
    }
});