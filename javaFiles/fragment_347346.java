public void onPause()
{
    ...                      // your logic for data-set changed.
    if (doesRecordExist)
        insectsAddRecordFragment.setInsects(isDefaultInsectTypes.get‌​InsectNamesList());
    ...
}