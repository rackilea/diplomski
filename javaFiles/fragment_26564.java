downloader.registerListener(this.listener)

def listener(progress: Int) {
  SwingUtilities.invokeLater(new Runnable {
    def run() {
      progressBar.setValue(progress)
      table.repaint()
    }
  })
}