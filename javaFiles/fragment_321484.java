@Stateless
public class VeranstaltungDao extends AbstractDao<Veranstaltung> {

        @Override
        public List<Veranstaltung> findAll() {
            final TypedQuery<Veranstaltung> query = getEm().createQuery(
                    "Select a FROM" + Veranstaltung.class.getSimpleName() +" a",
                    Veranstaltung.class);

            return query.getResultList();
        }

    }