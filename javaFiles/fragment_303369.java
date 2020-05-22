android {
 ...
splits {

// Configures multiple APKs based on screen density.
density {

// Configures multiple APKs based on screen density.
enable true

// Specifies a list of screen densities Gradle should not create multiple APKs for.
exclude "ldpi", "xxhdpi", "xxxhdpi" // Exclude what you don't require
}}}