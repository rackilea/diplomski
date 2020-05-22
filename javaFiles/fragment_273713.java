public class IconTest {

/**
 * @param args the command line arguments
 * @throws java.net.URISyntaxException
 * @throws java.io.IOException
 */
public static void main(String[] args) throws URISyntaxException, IOException {
    test4();
}

public static void test4() throws MalformedURLException, IOException, URISyntaxException{
    ExecutorService service = Executors.newFixedThreadPool(5);
    URI uri = IconTest.class.getResource("../resources/Icons").toURI();
    Path myPath;
    if (uri.getScheme().equals("jar")) {
        FileSystem fileSystem = FileSystems.newFileSystem(uri, Collections.<String, Object>emptyMap());
        myPath = fileSystem.getPath("Icons/");
    } else {
        myPath = Paths.get(uri);
    }
    IconFolder root = new IconFolder(myPath.toFile().getName());
    IconFolder parentFolder = root;
    HIcon currentIcon = null;
    IconFolder folder = null;
    HashMap<String,IconFolder> folders = new HashMap<>();
    folders.put(parentFolder.getName(), parentFolder);
    Stream<Path> walk = Files.walk(myPath, 10);
    Iterator<Path> it = walk.iterator();it.next();
    Info.Info("Starting loading icons....");
    ImageIO.setUseCache(false);
    while(it.hasNext()){
        Path path = it.next();
        if(path.toFile().isDirectory()){
            folder = new IconFolder(path.toFile().getName());
            folders.put(folder.getName(), folder);
            String parentName = path.getParent().toFile().getName();
            parentFolder = folders.get(parentName);
            parentFolder.addSubFolder(folder);
            currentIcon =null;
            Info.Info("Directory: " + path);
        }else{
            ImageLoadingTask task;
            URL url = path.toUri().toURL();
            String[] iconName;
            iconName = path.getFileName().toString().replaceAll("_000000", "").replaceAll(".png","").split("_",2);
            String imageName = iconName[0];
            String imageSize = iconName[1];
            if(currentIcon==null||!currentIcon.getName().equals(imageName)){
                currentIcon = new HIcon(imageName);
                folder.addIcon(currentIcon);
                task = new ImageLoadingTask(url,currentIcon,imageSize);
                service.submit(task);
            }else{
                task = new ImageLoadingTask(url,currentIcon,imageSize);
                service.submit(task);
            }
            //Info.Info("Image: " + imageName+"-->"+imageSize);
        }
    }
    service.shutdown();
    Info.Info("Finished loading icons....");
}

static public class ImageLoadingTask implements Callable<ImageIcon> {

    private final URL url;
    private final HIcon hIcon;
    private final String size;

    public ImageLoadingTask(URL url, HIcon hIcon, String size ) {
        this.url = url;
        this.hIcon=hIcon;
        this.size=size;
    }

    @Override
    public ImageIcon call() throws Exception {
        ImageIcon icon = new ImageIcon(ImageIO.read(url));
        hIcon.setIcon(icon, size);
        return icon;
    }
}
}