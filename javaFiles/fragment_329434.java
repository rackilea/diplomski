public class DialogPdfViewer extends Dialog {
    PDFView pdfView;
    byte[] decodedString;

    public interface OnDialogPdfViewerListener {
        void onAgreeClick(DialogPdfViewer dialogFullEula);

        void onCloseClick(DialogPdfViewer dialogFullEula);
    }

    public DialogPdfViewer(Context context, String base64, final DialogPdfViewer.OnDialogPdfViewerListener onDialogPdfViewerListener) {
        super(context);

        setContentView(R.layout.dialog_pdf_viewer);
        findViewById(R.id.dialog_pdf_viewer_close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogPdfViewerListener.onCloseClick(DialogPdfViewer.this);
            }
        });

        findViewById(R.id.dialog_pdf_viewer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogPdfViewerListener.onAgreeClick(DialogPdfViewer.this);
            }
        });

        decodedString = Base64.decode(base64.toString(), Base64.DEFAULT);

        pdfView = ((PDFView) findViewById(R.id.pdfView));
        pdfView.fromBytes(decodedString).load();

        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
                    onDialogPdfViewerListener.onCloseClick(DialogPdfViewer.this);
                }
                return true;
            }
        });

    }
}