publishing {
    repositories {
        maven {
            url "http://repo.mycompany.com/maven2"
            credentials(HttpHeaderCredentials) {
                name = "Private-Token"
                value = "REPLACE_WITH_YOUR_PERSONAL_ACCESS_TOKEN"
            }
            authentication {
                header(HttpHeaderAuthentication)
            }
        }
    }
}