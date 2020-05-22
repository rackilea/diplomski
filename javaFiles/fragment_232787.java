import java.util.HashMap;

/** This class holds many to many associations between two classes. */
public class AssociationHolder<LeftClass, RightClass, AssociationClass> {

    // -------------------------------------------------------
    // Attributes
    // -------------------------------------------------------

    private HashMap<LeftClass, HashMap<RightClass, AssociationClass>> associationsLeft = 
        new HashMap<LeftClass, HashMap<RightClass,AssociationClass>>();
    private HashMap<RightClass, HashMap<LeftClass, AssociationClass>> associationsRight = 
        new HashMap<RightClass, HashMap<LeftClass,AssociationClass>>();     

    // -------------------------------------------------------
    // Methods
    // -------------------------------------------------------

    /** 
     *  Set an association between two instance.
     *  Any prior association is overwritten.
     */
    public void setAssociation(LeftClass left, RightClass right, AssociationClass association) {

        // Get the map for the left 
        HashMap<RightClass, AssociationClass> leftMap = this.associationsLeft.get(left);

        // No association defined yet for this left key ? => Create new map
        if (leftMap == null) {
            leftMap = new HashMap<RightClass, AssociationClass>();
            this.associationsLeft.put(left, leftMap);
        }

        // Get the map for the right 
        HashMap<LeftClass, AssociationClass> rightMap = this.associationsRight.get(right);

        // No association defined yet for this right key ? => Create new map
        if (rightMap == null) {
            rightMap = new HashMap<LeftClass, AssociationClass>();
            this.associationsRight.put(right, rightMap);
        }

        // Set the assoication on both maps
        leftMap.put(right, association);
        rightMap.put(left, association);        

    } 

    /** @return null if no association found. */
    public AssociationClass getAssociation(LeftClass left, RightClass right) {

        // Use left maps (could have used the right one as well)
        HashMap<RightClass, AssociationClass> leftMap = this.associationsLeft.get(left);
        if (leftMap == null) return null;
        return leftMap.get(right);
    }

    /** Get all associations defined for a given Left instance.  */
    public HashMap<RightClass, AssociationClass> getAssociationsLeft(LeftClass left) {

        HashMap<RightClass, AssociationClass> leftMap = this.associationsLeft.get(left);

        // No map defined ? return empty one instead of null
        if (leftMap == null) {
            return new HashMap<RightClass, AssociationClass>();
        } else {
            return leftMap;
        }   
    }

    /** Get all associations defined for a given Right instance.  */
    public HashMap<LeftClass, AssociationClass> getAssociationsRight(RightClass right) {

        HashMap<LeftClass, AssociationClass> rightMap = this.associationsRight.get(right);

        // No map defined ? return empty one instead of null
        if (rightMap == null) {
            return new HashMap<LeftClass, AssociationClass>();
        } else {
            return rightMap;
        }   
    }

    /** 
     *  Remove an association between two instances.
     */
    public void removeAssociation(LeftClass left, RightClass right) {
        HashMap<RightClass, AssociationClass> leftMap = this.getAssociationsLeft(left);
        HashMap<LeftClass, AssociationClass> rightMap = this.getAssociationsRight(right);
        leftMap.remove(right);      
        rightMap.remove(left);  
    }
}