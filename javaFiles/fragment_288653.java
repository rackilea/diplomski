import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
@JobScope
public class FilesService {

    private List<File> files;

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}