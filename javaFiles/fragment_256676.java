package ekoncept.repositories;

import ...

@Repository
@Transactional
public interface FakturaRepository extends JpaRepository<Faktura, Integer> {
...
}