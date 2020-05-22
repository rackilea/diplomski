@Entity
@Table(name="persona_rel")
public class PersonaRelEnity implements Serializable {

    @EmbeddedId
    private PersonaRelPKEntity pk;

    ...
}

@Embeddable
public class PersonaRelPKEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name="per_tipo")
    private Integer perTipo;

    @Column(name="per_cod")
    private Integer perCod;

    ...
}

@Entity
@Table(name="usuarios")
public class UsuarioEntity implements Serializable {

    @EmbeddedId
    private UsuarioEntityPK id;

    @OneToOne
    @MapsId("personaRelPKEntity")
    @JoinColumns({
        @JoinColumn(name="per_tipo_usu", referencedColumnName="per_tipo"),
        @JoinColumn(name="per_cod_usu", referencedColumnName="per_cod")
    })
    private PersonaRelEnity personaRelEntity = null;

    ...
}

@Embeddable
public class UsuarioEntityPK implements Serializable {

    // matches the PK type of PersonaRelEnity
    private PersonaRelPKEntity personaRelPKEntity;

    ...
}