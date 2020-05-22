public class InscriptionSpecification
{
     public static Specification<Inscription> statusNameIn(String[] statusNames) {
        if (statusNames == null || statusNames.length == 0) {
            return null;
        }
        return (root, query, cb) -> {
            Inscription inscription = new Inscription();
            List<Byte> statusIds = new ArrayList<Byte>();
            for (String oneStatusName : statusNames) {
                statusIds.add(inscription.getStatusIdByName(oneStatusName));
            }
            return cb.isTrue(root.<String>get("status").in(statusIds));
        };
    }
}