test {
    onOutput { descriptor, event ->
        if (project.hasProperty('output')) {
            logger.lifecycle(event.message)
        }
    }
}