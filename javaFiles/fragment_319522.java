@Entity
@Table(name = "game_mode")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class GameMode extends BaseTable implements Serializable {

   // PROPERTIES
   @Id
   @GeneratedValue()
   @Column(name = "id")
   private UUID id;

   @ManyToOne // this will map game_id(game_mode) to id from (game)
   private Game game;
   ...
}