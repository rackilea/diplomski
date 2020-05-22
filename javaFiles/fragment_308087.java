private static Integer[] validIds = {
    A.instanceM.id, A.instanceZ.id, A.instanceL.id, A.instanceF.id, A.instanceP.id
};

public static boolean getHasCharacteristic3(A input) {
       return Arrays.asList(validIds).contains(input.id)
   }