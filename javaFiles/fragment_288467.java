<script>
        var attributes = {
            code:       "Test",
            archive:    "TestJApplet.jar",
            width:      600,            <!-- ALTER WIDTH HERE -->
            height:     600             <!-- ALTER HEIGHT HERE -->
        };
        var parameters = {jnlp_href:"launch.jnlp"}; <!-- Applet Parameters -->
        var version = "1.7"; <!-- Required Java Version -->
        deployJava.runApplet(attributes, parameters, version);
    </script>