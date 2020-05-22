public static BufferedImage getQRCodeImage(String amount) throws WriterException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode("bitcoin:"+kit.wallet().currentReceiveAddress().toString()+"?amount="+String.format("%.7f",Double.parseDouble(amount)), BarcodeFormat.QR_CODE, 200, 200);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

imageIcon.setImage(BackEnd.getQRCodeImage(cost));
            lblQRCode.setIcon(imageIcon);