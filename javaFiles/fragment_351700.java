@Entity
@Table(name = "story_translate")
public class StoryTranslate{
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;

   @ManyToOne
   @JoinColumn(name="story_id")
   private Story story;

   //some other fields, getters and setters
}