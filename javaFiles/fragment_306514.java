boolean performBuild(Integer applicationId) {
    ApplicationVO applicationVO = applicationServices.findAnyApplicationId(applicationId);

    ApplicationBuildVO androidApplicationBuildVO = new ApplicationBuildVO();
    androidApplicationBuildVO.setIsAndroid(true);
    androidApplicationBuildVO.setIsSuccess(appBuildSuccessful);
    androidApplicationBuildVO.setApplication(applicationVO);
    androidApplicationBuildVO.setSoftwareVersion(androidSoftwareVersionVO);
    androidApplicationBuildVO.setS3BucketName(mobileAppsBucketName);
    androidApplicationBuildVO.setS3ArtifactKey(androidArtifact);

    applicationVO.addBuild(androidApplicationBuildVO);

    applicationVO.setIsCurrentlyBeingBuilt(false);
    boolean updateApplicationResult = applicationServices.updateApplication(applicationVO);          
     }