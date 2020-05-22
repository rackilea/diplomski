public class PhotosActor {

    List<PhotoImage> images = new ArrayList<>();

    private String imgDir = "appimages/photos/";
    List<String> fileSet = new ArrayList<>();

    private final ScheduledExecutorService changeExecutor = Executors.newSingleThreadScheduledExecutor();

    Stage stage;

    int swapCounter = 0;

    public PhotosActor(Stage stage) {
        this.stage = stage;
    }

    public final void preload(){
        loadFileSet();
        changeExecutor.scheduleAtFixedRate(switchimg(), 10, 10, TimeUnit.SECONDS);
    }

    private Runnable switchimg(){
        Runnable run = () -> {
            try {
                swapCounter++;
                byte[] byteResult = readLocalRandomFile();
                Pixmap map = new Pixmap(byteResult, 0, byteResult.length);
                Gdx.app.postRunnable(() -> {
                    System.out.println("Swap counter: " +swapCounter);
                    Texture tex = new Texture(map);
                    map.dispose();
                    PhotoImage newImg = new PhotoImage(tex);
                    images.add(0,newImg);
                    stage.addActor(newImg);
                    addTransform(newImg);
                });
            } catch (Exception ex) {
                Logger.getLogger(PhotosActor.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        return run;
    }

    public void addTransform(Image img){
        switch(new Random().nextInt(3)){
            case 0:
                img.toBack();
                if(images.size()>1){ images.get(1).toBack(); }
                img.addAction(Actions.sequence(Actions.alpha(0),Actions.fadeIn(1f),Actions.delay(5),Actions.run(() -> {
                    removeOldImg();
                })));
            break;
            case 1:
                img.toBack();
                if(images.size()>1){ images.get(1).toBack(); }
                img.setPosition(1920f, 1080f);
                img.addAction(Actions.sequence(Actions.moveTo(0f, 0f, 5f),Actions.run(() -> {
                    removeOldImg();
                })));
            break;
            case 2:
                img.toBack();
                if(images.size()>1){ images.get(1).toBack(); }
                img.setScale(0f, 0f);
                img.setPosition(960f, 540f);
                img.addAction(Actions.sequence(Actions.parallel(Actions.scaleTo(1f, 1f, 5f), Actions.moveTo(0f, 0f, 5f)),Actions.run(() -> {
                    removeOldImg();
                })));
            break;
        }
    }

    private void removeOldImg(){
        if(images.size()>1){
            PhotoImage oldImg = images.remove(1);
            oldImg.remove();
            oldImg.getActions().clear();
            oldImg.dispose();
        }
        System.out.println("Amount of images: " + images.size());
    }

    private byte[] readLocalRandomFile() throws Exception{
        FileInputStream input = null;
        try {
            input = new FileInputStream(fileSet.get(new Random().nextInt(fileSet.size())));
            ByteArrayOutputStream out;
            try (InputStream in = new BufferedInputStream(input)) {
                out = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int n = 0;
                while (-1 != (n = in.read(buf))) {
                    out.write(buf, 0, n);
                }   
                out.close();
                return out.toByteArray();
            } catch (IOException ex) {
                Logger.getLogger(PhotosActor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PhotosActor.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new Exception("No data");
    }

    private void loadFileSet(){
        File[] files = new File(imgDir).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println("Loading: " + imgDir + file.getName());
                fileSet.add(imgDir + file.getName());
            }
        }
    }


}