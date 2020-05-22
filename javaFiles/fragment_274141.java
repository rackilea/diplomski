@MappedSuperclass
abstract class Material {}

@MappedSuperclass
abstract class LoanableMaterial extends Material implements Loanable {}

@Entity
class Journal extends Material {}

@Entity
class Book extends LoanableMaterial {}

@Entity
class DigitalMedia extends LoanableMaterial {}

@Entity
class Loan {
  @ManyToOne(targetEntity = LoanableMaterial.class)
  LoanableMaterial loaned;
}