module example {
    requires javafx.controls; // transitively requires javafx.base and javafx.graphics
    requires javafx.media; // transitively requires javafx.base and javafx.graphics

    // ... other directives ...

    /* 
     * Don't forget to "exports" the package containing your Application
     * class to at least the javafx.graphics module.
     */
}