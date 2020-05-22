test {
    onOutput { descriptor, event ->
        if (descriptor.name=='YOUR_TEST_METHOD_NAME' &&
                descriptor.className=='YOUR_PACKAGE_QUALIFIED_CLASS_NAME') {
            logger.lifecycle(event.message)
        }
    }
}