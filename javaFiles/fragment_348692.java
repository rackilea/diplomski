private CreateApplicationVersionRequest createApplicationVersion() {
    return new CreateApplicationVersionRequest()
            .withApplicationName("The app name")
            .withAutoCreateApplication(true)
            .withSourceBundle(new S3Location("bucket_name", deployedArtifactId))
            .withVersionLabel("a number for the version");
}