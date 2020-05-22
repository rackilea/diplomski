...
for (MultipartFile f : files) {
  UploadService uploadSrvc = uploadServiceFactory.getService(parentPkId);
  compService.submit(new ProcessMutlipartFile(f ,parentPkId,uploadService));
  futureList.add(compService.take());
}