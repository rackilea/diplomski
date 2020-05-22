@Entity
@Table(name = "grupo_setorial")
@SqlResultSetMapping(
        name = "mapeamentoDeQuadrantes",
        classes = {
                @ConstructorResult(
                        targetClass = Coordenada.class,
                        columns = {
                                @ColumnResult(name = "latitude"),
                                @ColumnResult(name = "longitude")
                        }
                )
        }
)
@NamedNativeQuery(
        name = "GrupoCensitario.obterPerimetroDosSetores",
        query = "SELECT latitude as latitude, longitude as longitude FROM coordenadas where id_setor IN (:setores)",
        resultSetMapping = "mapeamentoDeQuadrantes"
)
public class GrupoCensitario {