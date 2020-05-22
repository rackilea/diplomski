public class Drug implements Serializable{
    @ManyToMany
    private List<Disease> Diseases_Cured_By_This_Drug;

}

public class Disease implements Serializable{
    @ManyToMany(mappedBy="Diseases_Cured_By_This_Drug")
    private List<Drug> Cures_For_This_Disease;
}