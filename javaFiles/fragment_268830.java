@Entity
public class AbstractEmployeEntity extends AbstractPersonneEntity {

@OneToMany(fetch = FetchType.LAZY, mappedBy = "referent")
private Set<HotesseEntity> listeHotesse = new HashSet<HotesseEntity>();

@OneToMany(fetch = FetchType.LAZY, mappedBy = "referent")
private Set<InviteEntity> listeInvites = new HashSet<InviteEntity>();

@OneToMany(fetch = FetchType.LAZY, mappedBy = "referent")
private Set<AutreClientEntity> listeAutreClients = new HashSet<AutreClientEntity>();