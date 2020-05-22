public class AdapterServicios extends PagerAdapter implements CardAdapter {


private List<Model_Servicios> mData;
private List<CardView> mViews;
private float baseElevation;

public AdapterServicios(float baseElevation) {

    mData = new ArrayList<>();
    mViews = new ArrayList<>();
    this.baseElevation = baseElevation;

}

public void addCardItem(Model_Servicios item) {
    mViews.add(null);
    mData.add(item);