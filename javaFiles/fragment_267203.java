<script>
    document.MyApplet.killApplet();
</script>

public void killApplet() {
    AccessController.doPrivileged(new PrivilegedAction() {
        public Void run() {
            // kill the JVM System.exit(0); return null; 
        }
    });
}