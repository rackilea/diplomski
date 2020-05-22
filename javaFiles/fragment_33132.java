public static void forceActive(final Shell shell) {
    shell.getDisplay().asyncExec(new Runnable() {
        public void run() {
            shell.forceActive();
        }
    });
}