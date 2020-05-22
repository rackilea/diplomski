SELECT sq.rdo_code, sq.batch_no, sq.reference_no, sq.dln, sq.retrn_seq_num, sq.ftype_code, sq.tin, 
    sq.branch_code, sq.tax_type
       , sq.retrn_period
       , sq.name
       , sq.version
from (    
    SELECT rdo_code, batch_no, reference_no, dln, retrn_seq_num, ftype_code, tin, 
            branch_code, tax_type
               , retrn_period
               , version
               , name
               , rank() over (partition by rdo_code, batch_no,reference_no, dln, 
            retrn_seq_num, ftype_code, tin, branch_code, tax_type
                    order by version desc ) as rn
        FROM   rfp_returns_ref 
        WHERE  tin = '000079108' 
        AND    ftype_code = '1702EX' 
        AND    Upper(status) = Upper('POSTED') 
        ) sq
where sq.rn = 1 ;