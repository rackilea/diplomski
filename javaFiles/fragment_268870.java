import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class MainUI extends UI {

    private VerticalLayout layout;
    private Upload upload;

    private UploadReceiver uploadReceiver;

    @Autowired
    public MainUI(UploadReceiver uploadReceiver){
        this.uploadReceiver = uploadReceiver;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        // Set layout
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);


        // Add upload
        upload = new Upload("Upload a file", uploadReceiver);
        upload.addStartedListener(uploadReceiver);
        upload.addSucceededListener(uploadReceiver);
        upload.addProgressListener(uploadReceiver);
        layout.addComponent(upload);
    }
}