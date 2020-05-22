import java.util.*;

class Asset {
    public int id;
    public int time;

    public Asset(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public String toString() {
        return id + "  " + time;
    }
}


class Test {
    public static void main(String[] args) {

        List<Asset> assets = new ArrayList<Asset>();
        assets.add(new Asset(2, 467));
        assets.add(new Asset(3, 403));
        assets.add(new Asset(4, 602));
        assets.add(new Asset(3, 529));
        assets.add(new Asset(5, 398));

        // Sort according to time.
        Collections.sort(assets, new Comparator<Asset>() {
            @Override
            public int compare(Asset o1, Asset o2) {
                return new Integer(o1.time).compareTo(o2.time);
            }
        });

        // Remember the original indexes of each asset.
        final List<Asset> assetsCopy = new ArrayList<Asset>(assets);

        // Sort the collection based on the index of the first asset
        // with the same id
        Collections.sort(assets, new Comparator<Asset>() {

            private int firstIndexOf(int id) {
                for (int i = 0; i < assetsCopy.size(); i++)
                    if (assetsCopy.get(i).id == id)
                        return i;
                return -1;
            }

            @Override
            public int compare(Asset o1, Asset o2) {
                return new Integer(firstIndexOf(o1.id))
                        .compareTo(firstIndexOf(o2.id));
            }
        });


        for (Asset a : assets)
            System.out.println(a);
    }
}