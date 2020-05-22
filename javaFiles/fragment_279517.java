jfx {
    // ... normal configuration ...

    // your secondary entry points, each will inherit the configuration, unless you specify otherwise here
    secondaryLaunchers = [
        [
            appName: 'somethingDifferent2',
            mainClass: 'your.different.entrypoint.MainApp',
            // the following is required for an start-menu entry
            needMenu: true
        ]
    ]
}