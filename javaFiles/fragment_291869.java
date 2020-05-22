@Entity
@Table
public class Matricula {

    @Id
    private long matriculaId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "alunoId")
    private Aluno aluno;

    @OneToMany(mappedBy="turma")
    private List<Turma> turmas;

    @OneToMany(mappedBy="modalidade")
    private List<Modalidade> modalidades;
}

@Entity
@Table
public class Turma {
    //Put a unique ID here to be used as PK

    @ManyToOne
    @JoinColumn(name="matriculaId)
    private Matricula matricula;
}

@Entity
@Table
public class Modalidade {

    //Put a unique ID here to be used as PK

    @ManyToOne
    @JoinColumn(name="matriculaId)
    private Matricula matricula;
}

@Entity
@Table
public class Aluno {

    //Put a unique ID here to be used as PK

    @OneToOne(mappedBy="aluno")
    private Matricula matricula;
}