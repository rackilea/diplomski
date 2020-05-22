buildscript 
{
    repositories 
    {
        jcenter()
    }

    dependencies 
    {
        classpath 'org.javafxports:jfxmobile-plugin:1.0.8'
    }
}

apply plugin: 'org.javafxports.jfxmobile'
apply plugin: 'java'

retrolambda.oldJdk = 'C:/Program Files/Java/jdk1.7.0_79'