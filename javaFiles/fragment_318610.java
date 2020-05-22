SigCtl sigCtl = new SigCtl();
sigCtl.setProperty("Licence", "<the_license_you_get_from_them>");
        dc = new DynamicCapture();
        int rc = dc.capture(sigCtl, who, why, null, null); // dc.capture(sigCtl, "who", "why", null, null);
        if(rc == 0) {
            logger.info("signature captured successfully\n");
            SigObj sig = sigCtl.signature();
            sig.extraData("AdditionalData", "CaptureImage.java Additional Data");
            int flags = SigObj.outputFilename | SigObj.color32BPP | SigObj.encodeData;
            sig.renderBitmap(fileNameArray[1].getAbsolutePath(), 300, 233, "image/png", 0.7f, 0x000000, 0xffffff, 0.5f, 0.0f, flags); //flags are: filename, dimensionX, dimensionY, mimeType, inkWidth, inkColor, inkBackground, paddingX, paddingY
            FileOutputStream fos = new FileOutputStream(fileNameArray[0].getPath());
            fos.write(sig.sigData());
            fos.flush();
            fos.close();
            retrieve();
        }