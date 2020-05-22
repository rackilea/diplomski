apply plugin:'java'

repositories{
    mavenRepo(urls: "http://adterrasperaspera.com/lwjgl")
}

dependencies{
    compile "org.lwjgl:lwjgl:2.6"
    compile "org.lwjgl:lwjgl-util:2.6"
}