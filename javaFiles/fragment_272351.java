eclipseJdt << {
    ant.propertyfile(file: ".settings/org.eclipse.core.resources.prefs") {
        ant.entry(key: "eclipse.preferences.version", value: "1")
        ant.entry(key: "encoding/<project>", value: "utf-8")
    }
}

compileJava.options.encoding = "UTF-8"
compileTestJava.options.encoding = "UTF-8"