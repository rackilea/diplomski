//Class POJO that holds data
public class Group {
   private String name;
   private DocumentReference creator;

   public Group(){}

   public Group(String name, DocumentReference ref) {
       this.name = name;
       this.creator = ref;
   }

   public String getName() { return this.name; }
   public DocumentReference getCreator() { return this.creator; }

}

// Add to database
String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DocumentReference ref = db.collection("users").document(uid);

Group newGroup = new Group("My Group", ref);

db.collection("groups").document().set(newGroup);