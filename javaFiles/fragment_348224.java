public Recipe(Parcel in){
    this.id = in.readString();
    this.recipeName = in.readString();
    this.recipePreperation = in.readString();
    this.status = (Status) in.readSerializable();
}

public void writeToParcel(Parcel dest, int arg1) {
    dest.writeString(this.id);
    dest.writeString(this.recipeName);
    dest.writeString(this.recipePreperation);
    dest.writeSerializable(this.status);
}