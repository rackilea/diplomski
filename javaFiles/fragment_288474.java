/**
 * This fragment has a big {@ImageView} that shows PDF pages, and 2
 * {@link android.widget.Button}s to move between pages. We use a
 * {@link android.graphics.pdf.PdfRenderer} to render PDF pages as
 * {@link android.graphics.Bitmap}s.
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
public class PdfRendererFragment extends Fragment implements View.OnClickListener {

    /**
     * Key string for saving the state of current page index.
     */
    private static final String STATE_CURRENT_PAGE_INDEX = "current_page_index";

    /**
     * The filename of the PDF.
     */
    public String FILENAME;
    public String PURCHASE_ID;
    public int TICKETS_NUMBER;

    /**
     * File descriptor of the PDF.
     */
    private ParcelFileDescriptor mFileDescriptor;

    /**
     * {@link android.graphics.pdf.PdfRenderer} to render the PDF.
     */
    private PdfRenderer mPdfRenderer;

    /**
     * Page that is currently shown on the screen.
     */
    private PdfRenderer.Page mCurrentPage;

    /**
     * {@link android.widget.ImageView} that shows a PDF page as a {@link android.graphics.Bitmap}
     */
    private ImageView mImageView;

    /**
     * {@link android.widget.Button} to move to the previous page.
     */
    private Button mButtonPrevious;
    private ImageView mButtonZoomin;
    private ImageView mButtonZoomout;
    private Button mButtonNext;
    private float currentZoomLevel = 12;

    /**
     * PDF page index
     */
    private int mPageIndex;

    public PdfRendererFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pdf_renderer, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Retain view references.
        mImageView = (ImageView) view.findViewById(R.id.image);
        mButtonPrevious = (Button) view.findViewById(R.id.previous);
        mButtonNext = (Button) view.findViewById(R.id.next);
        mButtonZoomin = view.findViewById(R.id.zoomin);
        mButtonZoomout = view.findViewById(R.id.zoomout);

        // Bind events.
        mButtonPrevious.setOnClickListener(this);
        mButtonNext.setOnClickListener(this);
        mButtonZoomin.setOnClickListener(this);
        mButtonZoomout.setOnClickListener(this);

        mPageIndex = 0;
        // If there is a savedInstanceState (screen orientations, etc.), we restore the page index.
        if (null != savedInstanceState) {
            mPageIndex = savedInstanceState.getInt(STATE_CURRENT_PAGE_INDEX, 0);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FILENAME = getActivity().getIntent().getExtras().getString("pdfFilename");
        TICKETS_NUMBER = getActivity().getIntent().getExtras().getInt("tickets_number");
        PURCHASE_ID = getActivity().getIntent().getExtras().getString("purchaseGuid");
    }

    @Override
    public void onStart() {
        super.onStart();
        try {
            openRenderer(getActivity());
            showPage(mPageIndex);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), getString(R.string.ticket_file_not_found, FILENAME), Toast.LENGTH_SHORT).show();
            App app = (App) getActivity().getApplicationContext();
            TicketUtil.downloadTicket(app, PURCHASE_ID);
            getActivity().finish();
        }
    }

    @Override
    public void onStop() {
        try {
            closeRenderer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null != mCurrentPage) {
            outState.putInt(STATE_CURRENT_PAGE_INDEX, mCurrentPage.getIndex());
        }
    }

    /**
     * Sets up a {@link android.graphics.pdf.PdfRenderer} and related resources.
     */
    private void openRenderer(Context context) throws IOException {
        // In this sample, we read a PDF from the assets directory.
        File file = TicketUtil.getTicketFile(context, PURCHASE_ID);
        if (!file.exists()) {
            // Since PdfRenderer cannot handle the compressed asset file directly, we copy it into
            // the cache directory.
            InputStream asset = context.getAssets().open(FILENAME);
            FileOutputStream output = new FileOutputStream(file);
            final byte[] buffer = new byte[1024];
            int size;
            while ((size = asset.read(buffer)) != -1) {
                output.write(buffer, 0, size);
            }
            asset.close();
            output.close();
        }
        mFileDescriptor = ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY);
        // This is the PdfRenderer we use to render the PDF.
        if (mFileDescriptor != null) {
            mPdfRenderer = new PdfRenderer(mFileDescriptor);
        }
    }

    /**
     * Closes the {@link android.graphics.pdf.PdfRenderer} and related resources.
     *
     * @throws java.io.IOException When the PDF file cannot be closed.
     */
    private void closeRenderer() throws IOException {
        if (null != mCurrentPage) {
            mCurrentPage.close();
            mCurrentPage = null;
        }
        if (null != mPdfRenderer) {
            mPdfRenderer.close();
        }
        if (null != mFileDescriptor) {
            mFileDescriptor.close();
        }
    }

    /**
     * Zoom level for zoom matrix depends on screen density (dpiAdjustedZoomLevel), but width and height of bitmap depends only on pixel size and don't depend on DPI
     * Shows the specified page of PDF to the screen.
     *
     * @param index The page index.
     */
    private void showPage(int index) {
        if (mPdfRenderer.getPageCount() <= index) {
            return;
        }
        // Make sure to close the current page before opening another one.
        if (null != mCurrentPage) {
            mCurrentPage.close();
        }
        // Use `openPage` to open a specific page in PDF.
        mCurrentPage = mPdfRenderer.openPage(index);
        // Important: the destination bitmap must be ARGB (not RGB).
        int newWidth = (int) (getResources().getDisplayMetrics().widthPixels * mCurrentPage.getWidth() / 72 * currentZoomLevel / 40);
        int newHeight = (int) (getResources().getDisplayMetrics().heightPixels * mCurrentPage.getHeight() / 72 * currentZoomLevel / 64);
        Bitmap bitmap = Bitmap.createBitmap(
                newWidth,
                newHeight,
                Bitmap.Config.ARGB_8888);
        Matrix matrix = new Matrix();

        float dpiAdjustedZoomLevel = currentZoomLevel * DisplayMetrics.DENSITY_MEDIUM / getResources().getDisplayMetrics().densityDpi;
        matrix.setScale(dpiAdjustedZoomLevel, dpiAdjustedZoomLevel);
//        Toast.makeText(getActivity(), "width " + String.valueOf(newWidth) + " widthPixels " + getResources().getDisplayMetrics().widthPixels, Toast.LENGTH_LONG).show();
//        matrix.postTranslate(-rect.left/mCurrentPage.getWidth(), -rect.top/mCurrentPage.getHeight());

        // Here, we render the page onto the Bitmap.
        // To render a portion of the page, use the second and third parameter. Pass nulls to get
        // the default result.
        // Pass either RENDER_MODE_FOR_DISPLAY or RENDER_MODE_FOR_PRINT for the last parameter.
        mCurrentPage.render(bitmap, null, matrix, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
        // We are ready to show the Bitmap to user.
        mImageView.setImageBitmap(bitmap);
        updateUi();
    }

    /**
     * Updates the state of 2 control buttons in response to the current page index.
     */
    private void updateUi() {
        int index = mCurrentPage.getIndex();
        int pageCount = mPdfRenderer.getPageCount();
        if (pageCount == 1) {
            mButtonPrevious.setVisibility(View.GONE);
            mButtonNext.setVisibility(View.GONE);
        } else {
            mButtonPrevious.setEnabled(0 != index);
            mButtonNext.setEnabled(index + 1 < pageCount);
        }
        if (currentZoomLevel == 2) {
            mButtonZoomout.setActivated(false);
        } else {
            mButtonZoomout.setActivated(true);
        }
    }

    /**
     * Gets the number of pages in the PDF. This method is marked as public for testing.
     *
     * @return The number of pages.
     */
    public int getPageCount() {
        return mPdfRenderer.getPageCount();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.previous: {
                // Move to the previous page
                currentZoomLevel = 12;
                showPage(mCurrentPage.getIndex() - 1);
                break;
            }
            case R.id.next: {
                // Move to the next page
                currentZoomLevel = 12;
                showPage(mCurrentPage.getIndex() + 1);
                break;
            }
            case R.id.zoomout: {
                // Move to the next page
                --currentZoomLevel;
                showPage(mCurrentPage.getIndex());
                break;
            }
            case R.id.zoomin: {
                // Move to the next page
                ++currentZoomLevel;
                showPage(mCurrentPage.getIndex());
                break;
            }
        }
    }
}