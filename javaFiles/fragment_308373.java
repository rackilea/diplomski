android {
    // other stuff here

    buildTypes {
        debug {
          buildConfigField "String", "SERVER_URL", '"http://test.this-is-so-fake.com"'
        }

        release {
          buildConfigField "String", "SERVER_URL", '"http://prod.this-is-so-fake.com"'
        }

        mezzanine.initWith(buildTypes.release)

        mezzanine {
            buildConfigField "String", "SERVER_URL", '"http://stage.this-is-so-fake.com"'
        }
    }
}