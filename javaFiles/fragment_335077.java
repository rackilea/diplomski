static ScannerUI instance;

ScannerUI newScanner() {
   return instance == null || instance.isDisposed()? 
      instance = new ScannerUI() : instance;
}