android {

    ...

    packagingOptions {
        pickFirst "com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto_WF"
        // exclude "com/google/i18n/phonenumbers/data/PhoneNumberMetadataProto_WF"
    }
}