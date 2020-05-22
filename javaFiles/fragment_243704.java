public abstract class AudioSource {
    public abstract InputStream getStream() throws IOException;
}

public class FileAudioSource extends AudioSource {

    private final File audioFile;

    public FileAudioSource(File audioFile) {
        this.audioFile = audioFile;
    }

    @Override
    public InputStream getStream() throws FileNotFoundException {
        return new FileInputStream(audioFile);
    }
}

public class ResourceAudioSource extends AudioSource {

    private final String resourceName;

    public ResourceAudioSource(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public InputStream getStream() {
        return this.getClass().getResourceAsStream(resourceName)
    }
}