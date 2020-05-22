@Entity
class PostGroup {

 @Id
 String id; // this is will hold the formatted date YYMMDD

}

@Entity 
class Post {

  @Id
  Long id; // auto generated ID

  @Index
  Long sequence; //  the sequence number

  @Parent
  Key<PostGroup> group;

}