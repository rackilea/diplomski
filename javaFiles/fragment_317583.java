/* callback interface */
public interface FireBaseCallBack {
 void doCallBack(SomeClass sc);
}

public class FireBaseHandler{
 private FirebaseDatabase mFirebaseDatabase;
 private DatabaseReference mFireBaseReference;

 public FireBaseHandler(){
  this.mFirebaseDatabase = FirebaseDatabase.getInstance();
  this.mFireBaseReference = mFirebaseDatabase.getReference();

 public void operationOnFireBase(final FireBaseCallBack callback){
  mFireBaseReference.addListenerForSingleValueEvent(new ValueEventListener(){
   @Override void onDataChange(@NonNull DataSnapshot dataSnapshot){
    SomeClass temp = new SomeClass();
    temp.set/get on data in firebase
    callback.doCallBack(temp);
   }
  }
 }
}

public class SomeClass{
 private FireBaseHandler mFireBaseHandler;
 void someFunction(){
  mFireBaseHandler.operationOnFireBase(new FireBaseCallBack()){
    @Override void doCallBack(SomeClas sc){
     ...
    }
   });
  }
 }
}