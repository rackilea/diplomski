@Entity
@Getter
@Setter
@Table(name = "T_THEME")
public class ThemeEntity {

  /** Primary key of the table. */
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "theme_generator")
  @SequenceGenerator(name = "theme_generator", sequenceName = "DMDEOWNER.SEQ_NUM_THEME", allocationSize = 1)
  @Column(name = "f_num_theme")
  private Long idTechnique;

  //...
}