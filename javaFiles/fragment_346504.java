import org.gradle.plugins.ide.eclipse.model.SourceFolder 
eclipse.classpath.file {
    beforeMerged { classpath -> 
        classpath.entries.clear()
    }
    whenMerged {  cp -> 
        cp.entries.findAll { it instanceof SourceFolder && it.path.startsWith("src/main/") }*.output = "bin/main" 
        cp.entries.findAll { it instanceof SourceFolder && it.path.startsWith("src/test/") }*.output = "bin/test" 
        cp.entries.removeAll { it.kind == "output" }
    }
}