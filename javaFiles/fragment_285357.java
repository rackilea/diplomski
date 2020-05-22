List<DicomObject> dataList = new ArrayList<DicomObject>();

@Override
public void onDimseRSP(Association as, DicomObject cmd, DicomObject data) {
    if( shouldAdd(as, cmd) ) {
        dataList.add( data )
    }
}