allprojects {
    tasks.withType(Jar) { // includes War and Ear
        manifest {
            attributes ...
        }
    }
}