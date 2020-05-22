Message msg = Message.obtain();
Bundle data = new Bundle();
data.putSerializable("key", new printwriterHolder(mPrintWriter));

//class to hold print writer
class printwriterHolder implements Serializable{
    PrintWriter mPrintWriter;

    public printwriterHolder(PrintWriter mPrintWriter){
        this.mPrintWriter=mPrintWriter;
    }

    public PrintWriter getPrintWriter(){

        return mPrintWriter;
    }
}