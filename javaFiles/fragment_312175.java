inReader = mbtSocket.getInputStream();
outReader = mbtSocket.getOutputStream();
ProtocolAdapter mProtocolAdapter = new ProtocolAdapter(inReader, outReader);
mPrinterChannel = mProtocolAdapter.getChannel(ProtocolAdapter.CHANNEL_PRINTER);
Printer printer = new Printer(mPrinterChannel.getInputStream(), mPrinterChannel.getOutputStream());
try{
    textBuffer.append("{reset}{center}{s}Thank You!{br}");
    printer.reset();
    printer.printTaggedText(textBuffer.toString());
    printer.feedPaper(110);
    printer.flush();  
} catch(Exception e){
    e.printStackTrace();
    Log.e("Error: " + e, "Error");
}