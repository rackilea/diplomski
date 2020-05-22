@Entity
@IdClass(RecetteIngredientPK.class)
public class RecetteIngredient implements Serializable{

@Id
private long id;
private double qte;

@Id
@ManyToOne(targetEntity = Ingredient.class, cascade = CascadeType.MERGE)
private Ingredient ingredient;

@Id
@ManyToOne(targetEntity = Recette.class, cascade = CascadeType.MERGE)
private Recette recette;