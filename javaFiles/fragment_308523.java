public class ModelClass implements Parcelable {

        public ModelClass(Parcel in) {
            super(); 
            readFromParcel(in);
        }

        public static final Parcelable.Creator<ModelClass> CREATOR = new Parcelable.Creator<ModelClass>() {
            public ModelClass createFromParcel(Parcel in) {
                return new ModelClass (in);
            }

            public ModelClass [] newArray(int size) {

                return new ModelClass [size];
            }

        };

        public void readFromParcel(Parcel in) {
          Value1 = in.readInt();
          Value2 = in.readInt();
          Value3 = in.readInt();

        }
        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(Value1);
            dest.writeInt(Value2);  
            dest.writeInt(Value3);
       }
    }