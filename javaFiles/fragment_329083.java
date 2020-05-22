tasks.withType<Jar> {
    manifest {
        attributes["Multi-Release"] = "true"
    }
    from(sourceSets["main"].allSource)
    from(sourceSets["test"].allSource)
    {
        from(tasks["javadoc"]).into("/javadoc")
    }

}