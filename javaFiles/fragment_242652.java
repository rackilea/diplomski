@Entity
@Table(name = "empresa_sucursal")
public class EmpresaSucursal implements Serializable {

/.../

@JsonBackReference
@Id
@ManyToOne
@JoinColumn(name = "idsucursal" ,referencedColumnName="idsucursal")
private Sucursal sucursal;


@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

/.../

@JsonManagedReference
@OneToMany(mappedBy="empresa")
private List<EmpresaSucursal> empresaSucursal;
}