public class FileMeta {

    String name;
    String extension;
    int size;

    public FileMeta(String name, String extension, int size) {
      this.name = name;
      this.extension = extension;
      this.size = size;
    }

    public String getName() {
      return name;
    }

    public FileMeta setName(String name) {
      this.name = name;
      return this;
    }

    public String getExtension() {
      return extension;
    }

    public FileMeta setExtension(String extension) {
      this.extension = extension;
      return this;
    }

    public int getSize() {
      return size;
    }

    public FileMeta setSize(int size) {
      this.size = size;
      return this;
    }

  }

  public static void main(String[] args) {
    Map<String, List<FileMeta>> map = new ConcurrentHashMap<>();
    FileMeta obj1 = new FileMeta("razi", "mp3", 10);
    FileMeta obj2 = new FileMeta("test", "txt", 5);
    FileMeta obj3 = new FileMeta("song", "mp3", 20);
    FileMeta obj4 = new FileMeta("file", "js", 100);
    FileMeta obj5 = new FileMeta("mark", "txt", 10);
    FileMeta obj6 = new FileMeta("zoom", "js", 50);

    putinMap(map, obj1);
    putinMap(map, obj2);
    putinMap(map, obj3);
    putinMap(map, obj4);
    putinMap(map, obj5);
    putinMap(map, obj6);

    map.entrySet().stream().forEach(entry-> {
      int size = entry.getValue().stream().mapToInt(FileMeta::getSize).sum();
      System.out.println(entry.getKey() + " : " + size + " mb");
    });


  }

  private static void putinMap(Map<String, List<FileMeta>> map, FileMeta obj) {
    if (map.containsKey(obj.getExtension())) {
      map.get(obj.getExtension()).add(obj);
    } else {
      ArrayList<FileMeta> list = new ArrayList<>();
      list.add(obj);
      map.put(obj.getExtension(), list);
    }
  }