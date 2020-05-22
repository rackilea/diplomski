UIManager.put("TableHeader.background", Color.yellow);
EventQueue.invokeLater(new Runnable() {

    @Override
    public void run() {
        new Application();
    }
});