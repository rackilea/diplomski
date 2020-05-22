@Entity
@Table(name="APPRVL")
@AssociationOverrides({
    @AssociationOverride(name="statement", joinColumns = @JoinColumn(name = "EXPENSE_STATEMENT_ID"))
})    
public class ExpenseApproval extends Approval<ExpenseStatement>{
    private ExpenseStatement statement;

}