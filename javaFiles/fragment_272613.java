windowsVM.update()
            .defineNewExtension("shuitest")
            .withPublisher("Microsoft.Compute")
            .withType("CustomScriptExtension")
            .withVersion("1.9")
            .withMinorVersionAutoUpgrade()
            .withPublicSetting("commandToExecute", "netsh advfirewall firewall add rule name=\"Open Port 8077\" dir=in action=allow protocol=TCP localport=8077")
            .attach()
        .apply();