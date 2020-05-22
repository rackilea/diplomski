@XStreamAlias("PlayList")
public final class PlayList {
    @XStreamImplicit(itemFieldName = "File")
    private final List<String> files = new ArrayList<>();

    public void addFile(final String file) {
        checkFile(file);
        files.add(file);
    }

    public void removeFile(final String file) {
        checkFile(file);
        files.remove(file);
    }

    public List<String> getFiles() {
        return Collections.unmodifiableList(files);
    }

    private void checkFile(final String file) {
        if (file == null) {
            throw new NullPointerException();
        } else if (file.isEmpty()) {
            throw new IllegalArgumentException("is empty");
        }
    }

    public static void main(String[] args) {
        final PlayList playList = new PlayList();
        playList.addFile("Foo");
        playList.addFile("Bar");

        // Serialize
        final XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        final String xml = xstream.toXML(playList);
        System.out.println(xml);

        // Deserialize
        final PlayList playList2 = (PlayList) xstream.fromXML(xml);
        for (final String file : playList.getFiles()) {
            System.out.println(file);
        }
    }
}