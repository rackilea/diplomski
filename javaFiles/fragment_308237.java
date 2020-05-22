package teste01classes;    

public class SchoolClass {

  public static Alunos[] createAlunos() {
    Alunos[] aluno = new Alunos[20];
    aluno[0] = new Alunos();
    aluno[0].nome = "Abel";
    aluno[0].n1 = 10;
    aluno[0].n2 = 7;
    aluno[0].n3 = 8;
    //... n alunos
    return aluno;
  }
}