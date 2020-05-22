User.java:
...
public void setmData(UserEntity mData) {
    this.mData = mData;
    if(mData == null) {
      this.id = null;
    } else {
      this.id = mData.getmId();
    }
}

@Id
//!@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
...