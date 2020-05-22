public class MyReporter implements IExecutionListener {


@Override
public void onExecutionStart() {

}

@Override
public void onExecutionFinish() {

    ReportDownloadUtil.downloadReport();
}



}