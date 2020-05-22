public static void invokeInDispatchThreadIfNeeded(Runnable runnable) {
    if (EventQueue.isDispatchThread()) {
        runnable.run();
    } else {
        SwingUtilities.invokeLater(runnable);
    }
}