android.libraryVariants.all { variant ->
    task("jar${variant.name}", type: Jar) {
        description "Bundles compiled .class files into a JAR file for $variant.name."
        dependsOn variant.javaCompile
        from variant.javaCompile.destinationDir
        exclude '**/R.class', '**/R$*.class', '**/R.html', '**/R.*.html'
    }
}