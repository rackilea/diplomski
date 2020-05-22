public Image generateQR(int width, int height) {
    File root = Services.get(StorageService.class)
            .flatMap(StorageService::getPrivateStorage)
            .orElseThrow(() -> new RuntimeException("Storage Service not found"));

    String uuid = Services.get(DeviceService.class)
            .map(DeviceService::getUuid)
            .orElse("123456789");

    MultiFormatWriter codeWriter = new MultiFormatWriter();

    // Add maximum correction
    Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

    try {
        BarcodeFormat format = BarcodeFormat.QR_CODE;
        BitMatrix bitMatrix = codeWriter.encode(uuid, format, 
               width, height, hints);  // <--- add hints
        ...
        return writableImage;
    }
}