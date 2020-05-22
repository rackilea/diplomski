try {
   dataService.exportData(list, selectedFile);
} catch (Exception e) {
   UiUtils.showError(new ApplicationException(e), e );
} finally {
  ...
}