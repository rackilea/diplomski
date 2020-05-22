<script language="javascript">
    var Manifest = Java.type("java.util.jar.Manifest");
    var Files = Java.type("java.nio.file.Files");
    var Paths = Java.type("java.nio.file.Paths");
    var BufferedInputStream = Java.type("java.io.BufferedInputStream");

    var path = Paths.get(
        project.getProperty("buildDirectory"),
        "plugins/xyz.abc.e.tool.sa.rcp/META-INF/MANIFEST.MF");

    var stream = new BufferedInputStream(Files.newInputStream(path));
    var manifest = new Manifest(stream);
    stream.close();

    var version = manifest.getMainAttributes().getValue("Bundle-Version");
    project.setProperty("Bundle-Version", version);
</script>