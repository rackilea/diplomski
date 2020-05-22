credentials(HttpHeaderCredentials) {
    if (project.hasProperty('jobToken')) {
      name = "Job-Token"
      value = project.property('jobToken')
    } else {
      name = "Private-Token"
      value = "REPLACE_WITH_YOUR_PERSONAL_ACCESS_TOKEN"
    }
}