buildTypes {
    staging {
        buildConfigField "boolean", "IS_STAGING", "true"
    }

    release {
        buildConfigField "boolean", "IS_STAGING", "false"
    }
}