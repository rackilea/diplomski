public class FullSizeImageDialog extends Dialog {
private ImageView imageView;
private ProgressBar fullImageProgreesBar;
private Context dialogContext;

public FullSizeImageDialog(@NonNull Context context) {
    super(context);
    setContentView(R.layout.full_size_image_dialog);
    dialogContext = context;
    imageView = findViewById(R.id.full_size_image);
    fullImageProgreesBar = findViewById(R.id.fullImageProgreesBar);
    }
}