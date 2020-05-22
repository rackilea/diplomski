onRadioItemClick  onRadioItemClick;
interface onRadioItemClick{
    void onCheck(String str); // if you want pass any data when you need
}

public void setOnRadioItemClick(GalleryAdater.onRadioItemClick onRadioItemClick) {
    this.onRadioItemClick = onRadioItemClick;
}