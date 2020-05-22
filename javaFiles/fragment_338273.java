@Table("CHOICE")
@Entity
class Choice {

<....>

@Column(name = "CORRECT")
private Boolean correct = false;

<....>


private Boolean getCorrect(){
   return correct;
}