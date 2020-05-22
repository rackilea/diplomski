// transfer is of type IncomingFileTransfer, created by
// FileTransferRequet.accept()
final String fileName = transfer.getFileName();
transfer.recieveFile(new File(fileName));
LOG.info("Incoming file transfer: " + fileName);
LOG.info("Transfer status is: " + transfer.getStatus());
while (!transfer.isDone())
{
    final double progress = transfer.getProgress();
    final double progressPercent = progress * 100.0;
    String percComplete = String.format("%1$,.2f", progressPercent);
    LOG.info("Transfer status is: " + transfer.getStatus());
    LOG.info("File transfer is " + percComplete + "% complete");
    Thread.sleep(1000);
}