public class ImageContainer implements Serializable, Parcelable  {
/**
 * 
 */
private static final long serialVersionUID = 1L;

public ImageContainer() {
    // TODO Auto-generated constructor stub
}
public ImageContainer(Parcel in) {
    // TODO Auto-generated constructor stub
    readFromParcel(in);
}


/**
 * custom images in this article
 */
@SerializedName("Image")
ArrayList<ImageCls> alCustomImages=new ArrayList<ImageCls>();

public ArrayList<ImageCls> getAlCustomImages() {
    return alCustomImages;
}
public void setAlCustomImages(ArrayList<ImageCls> alCustomImages) {
    this.alCustomImages = alCustomImages;
}
@Override
public int describeContents() {
    // TODO Auto-generated method stub
    return 0;
}
@Override
public void writeToParcel(Parcel dest, int flags) {
    // TODO Auto-generated method stub
    dest.writeList(alCustomImages);
}
@SuppressWarnings("unchecked")
private void readFromParcel(Parcel in) {
    // TODO Auto-generated method stub
    this.alCustomImages = in.readArrayList(ImageCls.class.getClassLoader());
}

@SuppressWarnings("rawtypes")
public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
    public ImageContainer createFromParcel(Parcel in) {
        return new ImageContainer(in);
    }

    public ImageContainer[] newArray(int size) {
        return new ImageContainer[size];
    }
};
}