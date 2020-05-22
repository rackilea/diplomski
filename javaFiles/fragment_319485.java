SELECT (l.paid_date),c.customer_name,IF(@total=0,(SELECT total_amount FROM 
payment_loan WHERE loan_id=99)-(SELECT (installment_amount_month) FROM
payment_loan WHERE loan_id=99)*(SELECT (total_installments) 
FROM payment_loan, (SELECT @total:=0, @amountDue:=0) setup
   WHERE loan_id=99),
       (SELECT (installment_amount_month) FROM payment_loan WHERE
       loan_id=99))AS AmountDue,
           @amountDue:=@amountDue+(SELECT IF(@total=0,(SELECT (total_amount)
          FROM payment_loan WHERE loan_id=99)-(SELECT (installment_amount_month) FROM payment_loan 
        WHERE loan_id=99)*(SELECT (total_installments) FROM payment_loan 
        WHERE loan_id=99),(SELECT (installment_amount_month) FROM 
      payment_loan WHERE loan_id=99))) as ComulativeDue,
     l.amount AS AmountPaid, @total := @total +l.amount AS comulativePaid, 
     (@total/@amountDue ) as percentage FROM payments_details l Join 
     customer c on (c.customer_id=l.customer_id) WHERE l.customer_id=115 
    GROUP BY l.paid_date ORDER BY   l.paid_date DESC LIMIT 1  ;